package com.example.readermanga.ui.auth.sign_in

import com.example.core_ui.base.BaseViewModel

class SignInViewModel : BaseViewModel<SignInViewState>() {



    override fun getInitialUiState(): SignInViewState {
        return SignInViewState()
    }
}