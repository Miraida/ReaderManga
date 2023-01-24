package com.example.readermanga.ui.screen

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.core_ui.extension.navigate
import com.example.core_ui.ui_helpers.NavCommand
import com.example.core_ui.ui_helpers.NavCommands
import com.example.readermanga.R

class SplashFragment : Fragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigate(
            NavCommand(
                NavCommands.DeepLink(
                    url = Uri.parse("https://manga-reader/auth"),
                    isModal = true,
                    isSingleTop = true
                )
            )
        )
    }

}