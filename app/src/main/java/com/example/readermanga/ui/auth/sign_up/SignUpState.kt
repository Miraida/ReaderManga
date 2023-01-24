package com.example.readermanga.ui.auth.sign_up

import com.example.core_ui.base.BaseSingleEvents
import com.example.core_ui.base.BaseUiState

data class SignUpState(
    var loading: Boolean = false,
    var event: BaseSingleEvents? = null,
    var userNameError:Int? = null,
    var passwordError:Int? = null,
    var nickNameError:Int? = null,
    var imagePathError:Int? = null
) : BaseUiState
