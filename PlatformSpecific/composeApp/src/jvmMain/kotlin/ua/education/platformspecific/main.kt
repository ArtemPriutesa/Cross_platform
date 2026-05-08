package ua.education.platformspecific

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.compose.AppTheme
import ua.education.platformspecific.di.initKoin
import ua.education.platformspecific.ui.root.AppScaffold

fun main() = application {
    initKoin { printLogger() }
    Window(
        onCloseRequest = ::exitApplication,
        title = "PlatformSpecific",
    ) {
        AppTheme {
            AppScaffold()
        }
    }
}