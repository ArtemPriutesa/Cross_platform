package com.ua.laba_2.ui.theme.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ua.laba_2.ui.theme.screens.buttons.ButtonsScreen
import com.ua.laba_2.ui.theme.screens.checkboxes.CheckboxesScreen
import com.ua.laba_2.ui.theme.screens.chips.ChipsScreen
import com.ua.laba_2.ui.theme.screens.datepicker.DatePickerScreen
import com.ua.laba_2.ui.theme.screens.dialog.DialogScreen
import com.ua.laba_2.ui.theme.screens.divider.DividerScreen
import com.ua.laba_2.ui.theme.screens.main.MainScreen
import com.ua.laba_2.ui.theme.screens.progressbar.ProgressBarScreen
import com.ua.laba_2.ui.theme.screens.radiobutton.RadioButtonScreen
import com.ua.laba_2.ui.theme.screens.switch.SwitchScreen
import com.ua.laba_2.ui.theme.screens.timepicker.TimePickerScreen
import kotlinx.coroutines.launch
import laba_2.composeapp.generated.resources.Res
import laba_2.composeapp.generated.resources.back
import laba_2.composeapp.generated.resources.buttons
import laba_2.composeapp.generated.resources.checkboxes
import laba_2.composeapp.generated.resources.chips
import laba_2.composeapp.generated.resources.datepickerDialog
import laba_2.composeapp.generated.resources.dialog
import laba_2.composeapp.generated.resources.divider
import laba_2.composeapp.generated.resources.main
import laba_2.composeapp.generated.resources.progressBar
import laba_2.composeapp.generated.resources.radioButton
import laba_2.composeapp.generated.resources.switch
import laba_2.composeapp.generated.resources.timepickerDialog
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource


enum class AppScreen(val title: StringResource){
    Main(title = Res.string.main),
    Buttons(title = Res.string.buttons),
    Checkboxes(title = Res.string.checkboxes),
    Chips(title = Res.string.chips),
    DatepickerDialog(title = Res.string.datepickerDialog),
    Dialog(title = Res.string.dialog),
    Divider(title = Res.string.divider),
    ProgressBar(title = Res.string.progressBar),
    RadioButton(title = Res.string.radioButton),
    Switch(title = Res.string.switch),
    TimepickerDialog(title = Res.string.timepickerDialog)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: AppScreen,
    canNavigationBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if(canNavigationBack){
                IconButton(onClick = navigateUp){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(Res.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun AppNavigation(){
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.Main.name
    )

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
       topBar = {
           AppBar(
               currentScreen = currentScreen,
               canNavigationBack = navController.previousBackStackEntry != null,
               navigateUp = { navController.navigateUp() } )

       },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreen.Main.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ){
            composable(route = AppScreen.Main.name) {
                MainScreen(
                    onButtonsClicked = {navController.navigate(AppScreen.Buttons.name)},
                    onCheckboxesClicked = {navController.navigate(AppScreen.Checkboxes.name)},
                    onChipsCkicked = {navController.navigate(AppScreen.Chips.name)},
                    onDatepickerClicked = {navController.navigate(AppScreen.DatepickerDialog.name)},
                    onDialogClicked = {navController.navigate(AppScreen.Dialog.name)},
                    onDividerClicked = {navController.navigate(AppScreen.Divider.name)},
                    onProgresBar = {navController.navigate(AppScreen.ProgressBar.name)},
                    onRadioButtonClicked = {navController.navigate(AppScreen.RadioButton.name)},
                    onSwishClicked = {navController.navigate(AppScreen.Switch.name)},
                    onTimePickerClicked = {navController.navigate(AppScreen.TimepickerDialog.name)}
                ) { }
            }
            composable(route = AppScreen.Buttons.name) {
                ButtonsScreen(
                    onFilledButtonClicked = { text ->
                        scope.launch {
                            snackbarHostState
                                .showSnackbar(
                                    message = text,
                                    duration = SnackbarDuration.Short
                                )
                        }
                    }
                )
            }
            composable(route = AppScreen.Checkboxes.name) {
                CheckboxesScreen()
            }
            composable(route = AppScreen.Chips.name) {
                ChipsScreen()
            }
            composable(route = AppScreen.DatepickerDialog.name){
                DatePickerScreen()
            }
            composable(route = AppScreen.Dialog.name){
                DialogScreen()
            }
            composable(route = AppScreen.Divider.name){
                DividerScreen()
            }
            composable(route = AppScreen.ProgressBar.name){
                ProgressBarScreen()
            }
            composable(route = AppScreen.RadioButton.name){
                RadioButtonScreen()
            }
            composable(route = AppScreen.Switch.name){
                SwitchScreen()
            }
            composable(route = AppScreen.TimepickerDialog.name){
                TimePickerScreen()
            }
        }

    }
}



