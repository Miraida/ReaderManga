package com.example.readermanga.ui.auth.sign_in

import com.example.core_ui.base.BaseFragment
import com.example.core_ui.base.BaseSingleEvents
import com.example.core_ui.extension.navigate
import com.example.core_ui.extension.showSnackbar
import com.example.readermanga.databinding.FragmentSignInBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment(val changeViewPagerItem: (Int) -> Unit) :
    BaseFragment<SignInViewState, SignInViewModel, FragmentSignInBinding>(FragmentSignInBinding::inflate) {

    override val vm: SignInViewModel by viewModel()

    override fun render(viewState: SignInViewState) {

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
        ui.signNotAccount.setOnClickListener {
            changeViewPagerItem(1)
        }
    }

}