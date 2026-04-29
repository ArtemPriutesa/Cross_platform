package com.ua.laba_2.ui.shared.dialogs

import androidx.compose.runtime.Composable

@Composable
actual fun AddTimeDialogWrapper(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    content()
}