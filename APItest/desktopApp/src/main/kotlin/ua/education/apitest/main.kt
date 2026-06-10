package ua.education.apitest

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ua.education.apitest.di.initKoin
import ua.education.apitest.ui.presentation.App

fun main() = application {
    initKoin {printLogger()}
    Window(
        onCloseRequest = ::exitApplication,
        title = "APItest",
    ) {
        App()
    }
}