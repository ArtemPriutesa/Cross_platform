package com.ua.laba_2.ui.Theme.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerButtons
import androidx.compose.ui.tooling.preview.Preview
import laba_2.composeapp.generated.resources.Res
import laba_2.composeapp.generated.resources.buttons
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreen(
    onButtonsClicked: () -> Unit
){
    Button(
        modifier = Modifier.fillMaxSize(),
        onClick = {
            onButtonsClicked()
        }
    ){
        Text(stringResource(Res.string.buttons))
    }

}

@Preview
@Composable
private fun MeinScreenPreview(){
    MainScreen {  }
}

