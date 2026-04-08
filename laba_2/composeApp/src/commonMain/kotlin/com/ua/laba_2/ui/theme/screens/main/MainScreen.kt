package com.ua.laba_2.ui.theme.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import laba_2.composeapp.generated.resources.Res
import laba_2.composeapp.generated.resources.buttons
import laba_2.composeapp.generated.resources.checkboxes
import laba_2.composeapp.generated.resources.chips
import laba_2.composeapp.generated.resources.datepickerDialog
import laba_2.composeapp.generated.resources.dialog
import laba_2.composeapp.generated.resources.divider
import laba_2.composeapp.generated.resources.progressBar
import laba_2.composeapp.generated.resources.radioButton
import laba_2.composeapp.generated.resources.switch
import laba_2.composeapp.generated.resources.timepickerDialog
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainScreen(
    onButtonsClicked: () -> Unit,
    onCheckboxesClicked: () -> Unit,
    onChipsCkicked: () -> Unit,
    onDatepickerClicked: () -> Unit,
    onDialogClicked: () -> Unit,
    onDividerClicked: () -> Unit,
    onProgresBar: () -> Unit,
    onRadioButtonClicked: () -> Unit,
    onSwishClicked: () -> Unit,
    onTimePickerClicked: () -> Unit,
    function: () -> Unit
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                onButtonsClicked()
            }
        ) {
            Text(stringResource(Res.string.buttons))
        }
        Button(
            onClick = {
                onCheckboxesClicked()
            }
        ) {
            Text(stringResource(Res.string.checkboxes))
        }
        Button(
            onClick = {
                onChipsCkicked()
            }
        ){
            Text(stringResource(Res.string.chips))
        }
        Button(
            onClick = {
                onDatepickerClicked()
            }
        ){
            Text(stringResource(Res.string.datepickerDialog))
        }
        Button(
            onClick = {
                onDialogClicked()
            }
        ){
            Text(stringResource(Res.string.dialog))
        }
        Button(
            onClick = {
                onDividerClicked()
            }
        ){
            Text(stringResource(Res.string.divider))
        }
        Button(
            onClick = {
                onProgresBar()
            }
        ){
            Text(stringResource(Res.string.progressBar))
        }
        Button(
            onClick = {
                onRadioButtonClicked()
            }
        ){
            Text(stringResource(Res.string.radioButton))
        }
        Button(
            onClick = {
                onSwishClicked()
            }
        ){
            Text(stringResource(Res.string.switch))
        }
        Button(
            onClick = {
                onTimePickerClicked()
            }
        ){
            Text(stringResource(Res.string.timepickerDialog))
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
        {},
    ) { }
}

