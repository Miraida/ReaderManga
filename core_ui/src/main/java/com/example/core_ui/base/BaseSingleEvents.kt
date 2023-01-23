package com.example.core_ui.base

import com.example.core_ui.ui_helpers.NavCommand


sealed class BaseSingleEvents {
    class ShowToast(val type: ToastType, val message: String): BaseSingleEvents()
    class Navigate(val commands: NavCommand? = null, val isHasNavigate: Boolean = false) : BaseSingleEvents()
}

enum class ToastType {
    SUCCESS, INFO, ERROR
}