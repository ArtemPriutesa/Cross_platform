package ua.education.platformspecific

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.example.compose.AppTheme
import ua.education.platformspecific.di.initKoin
import ua.education.platformspecific.ui.root.AppScaffold

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin { printLogger() }
    ComposeViewport {
        AppTheme {
            AppScaffold()
        }
    }
}