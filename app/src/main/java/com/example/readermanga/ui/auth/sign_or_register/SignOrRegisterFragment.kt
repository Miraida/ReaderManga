package com.example.readermanga.ui.auth.sign_or_register

import com.example.core_ui.base.BaseFragment
import com.example.core_ui.base.BaseSingleEvents
import com.example.core_ui.extension.navigate
import com.example.core_ui.extension.showSnackbar
import com.example.readermanga.databinding.FragmentSignOrRegisterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignOrRegisterFragment :
    BaseFragment<SignOrRegisterUiState, SignOrRegisterViewModel, FragmentSignOrRegisterBinding>(
        FragmentSignOrRegisterBinding::inflate
    ) {

    override val vm: SignOrRegisterViewModel by viewModel()

    override fun setupListeners() {
        ui.registerBtn.setOnClickListener {
            vm.onClicked(false)
        }
        ui.signBtn.setOnClickListener {
            vm.onClicked(true)
        }
    }

    override fun render(viewState: SignOrRegisterUiState) {}

    override fun handleSingleEvent(event: BaseSingleEvents) {
        when (event) {
            is BaseSingleEvents.Navigate -> {
                event.commands?.let {
                    navigate(
                        it
                    )
                }
            }
            is BaseSingleEvents.ShowToast -> {
                showSnackbar(ui.root, event.message, layoutInflater, event.type.name)
            }
        }
    }
}