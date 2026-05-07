package com.ua.laba_2.ui.shared.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogWindow
import androidx.compose.ui.window.rememberDialogState

@Composable
actual fun MeetingDialogWrapper(
    onDismiss: () -> Unit,
    content: @Composable (() -> Unit)
) {
    DialogWindow(
        onCloseRequest = { onDismiss() },
        title = "Meetings",
        state = rememberDialogState(),
        content = {
            content()
        }
    )
}