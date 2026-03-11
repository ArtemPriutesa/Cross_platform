package com.ua.laba_2

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Laba_2",
    ) {
        App()
    }
}