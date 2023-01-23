package com.example.core_ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<S: BaseUiState> : ViewModel(){
    private val eventChannel = Channel<BaseSingleEvents>(Channel.UNLIMITED)

    val singleEvent: Flow<BaseSingleEvents> get() = eventChannel.receiveAsFlow()

    protected suspend fun sendEvent(event: BaseSingleEvents) = eventChannel.send(event)

    var viewState: StateFlow<S>

    protected val _viewState = MutableStateFlow(getInitialUiState())

    init {
        viewState =
                _viewState
                .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), getInitialUiState())
    }
    fun setChanges(updatedUiState: S) {
        _viewState.tryEmit(updatedUiState)
    }
    protected abstract fun getInitialUiState() : S

    protected fun <T> Flow<ResultStatus<T>>.getData(
        returnOnFailure : (messageError : String?) -> S,
        returnOnLoading : () -> S,
        returnOnSuccess : (data : T?) -> S,
    ){
        viewModelScope.launch(Dispatchers.IO) {
            collect {
                when(it) {
                    is ResultStatus.Loading -> {
                        setChanges(returnOnLoading())
                    }
                    is ResultStatus.Success -> {
                        setChanges(returnOnSuccess(it.data))
                    }
                    is ResultStatus.Error -> {
                        setChanges(returnOnFailure(it.error))
                    }
                }
            }
        }
    }

}