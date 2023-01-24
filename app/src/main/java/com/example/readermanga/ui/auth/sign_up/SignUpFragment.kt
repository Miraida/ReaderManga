package com.example.readermanga.ui.auth.sign_up

import com.example.core_ui.base.BaseFragment
import com.example.core_ui.base.BaseSingleEvents
import com.example.core_ui.extension.navigate
import com.example.core_ui.extension.showSnackbar
import com.example.readermanga.databinding.FragmentSignUpBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment(val changeViewPagerItem: (Int) -> Unit) :
    BaseFragment<SignUpState, SignUpViewModel, FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override val vm: SignUpViewModel by viewModel()

    override fun render(viewState: SignUpState) {
        with(viewState) {

        }
    }

    override fun handleSingleEvent(event: BaseSingleEvents) {
        when (event) {
            is BaseSingleEvents.ShowToast -> {
                showSnackbar(
                    ui.root,
                    event.message,
                    layoutInflater,
                    event.type.toString()
                )
            }
            is BaseSingleEvents.Navigate -> {
                event.commands?.let { navigate(it) }
            }
        }
    }

    override fun setupListeners() {
        ui.registerHaveAccount.setOnClickListener {
            changeViewPagerItem(0)
        }
    }

}