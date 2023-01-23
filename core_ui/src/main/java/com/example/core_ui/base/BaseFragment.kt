package com.example.core_ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.core_ui.ui_helpers.collectIn

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<S : BaseUiState, VM : BaseViewModel<S>, VB : ViewBinding>(
    private val inflate: Inflate<VB>,
) : Fragment() {

    protected abstract val vm: VM

    private var _binding: VB? = null
    val ui get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return ui.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupPermissionsLaunchers()
        bindVM()
    }

    private fun bindVM() {
        vm.viewState.collectIn(this) {
            render(it)
        }
        vm.singleEvent.collectIn(this) {
            handleSingleEvent(it)
        }
    }

    protected open fun setupPermissionsLaunchers() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListeners()
        setupRequests()
        setupObservers()
    }

    /**
     * Entry point for the [viewState] to render itself based on a [BaseUiState].
     */
    abstract fun render(viewState: S)

    /**
     * Entry point for the [BaseSingleEvents] to handle single event.
     */
    abstract fun handleSingleEvent(event: BaseSingleEvents)

    /**
     * Initialize views
     */
    protected open fun initialize() {
    }

    /**
     * setup listeners
     */
    protected open fun setupListeners() {
    }

    protected open fun setupRequests() {
    }

    protected open fun setupObservers() {
    }
}