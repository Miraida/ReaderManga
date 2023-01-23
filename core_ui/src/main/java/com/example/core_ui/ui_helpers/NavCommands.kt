package com.example.core_ui.ui_helpers

import android.net.Uri

sealed class NavCommands {
    data class DeepLink(val url: Uri,
                        val isModal: Boolean,
                        val isSingleTop: Boolean = false
    ) : NavCommands()
}