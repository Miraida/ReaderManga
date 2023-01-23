package com.example.core_ui.extension

import androidx.fragment.app.Fragment
import com.example.core_ui.ui_helpers.NavCommand
import com.example.core_ui.ui_helpers.NavigationProvider

fun Fragment.navigate(navCommand: NavCommand) {
    (requireActivity() as? NavigationProvider)?.launch(navCommand)
}