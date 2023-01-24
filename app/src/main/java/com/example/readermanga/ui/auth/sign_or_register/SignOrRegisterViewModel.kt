package com.example.readermanga.ui.auth.sign_or_register

import android.net.Uri
import androidx.lifecycle.viewModelScope
import com.example.core_ui.base.BaseSingleEvents
import com.example.core_ui.base.BaseViewModel
import com.example.core_ui.ui_helpers.NavCommand
import com.example.core_ui.ui_helpers.NavCommands
import kotlinx.coroutines.launch

class SignOrRegisterViewModel : BaseViewModel<SignOrRegisterUiState>() {


    override fun getInitialUiState() = SignOrRegisterUiState()

    fun onClicked(isSignIn: Boolean) {
        viewModelScope.launch {
            val number = if (isSignIn) "1" else "2"
            sendEvent(
                BaseSingleEvents.Navigate(
                    NavCommand(
                        NavCommands.DeepLink(
                            Uri.parse("https://reader-mango/sign?sign=$number"),
                            isModal = false,
                            isSingleTop = false
                        )
                    )
                )
            )
        }
    }
}