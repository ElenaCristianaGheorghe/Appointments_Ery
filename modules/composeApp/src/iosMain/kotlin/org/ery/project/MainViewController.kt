package org.ery.project

import androidx.compose.ui.window.ComposeUIViewController
import org.ery.project.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}