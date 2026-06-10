package ua.education.apitest

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import ua.education.apitest.di.initKoin
import ua.education.apitest.ui.presentation.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        initKoin { printLogger() }
        App()
    }
}