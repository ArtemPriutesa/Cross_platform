package com.ua.laba_2.ui.theme.screens.chips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChipsScreen(){
    var selected by remember{ mutableStateOf(false) }
    var isSelected by remember { mutableStateOf(false) }
    var enabled by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        AssistChip(
            onClick = { selected = !selected },
            label = {
                Text("AssistChip")
                    },
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },

        )

        FilterChip(
            selected = isSelected,
            onClick = { isSelected = !isSelected },
            label = { Text("FilterChip") },
            leadingIcon = if (isSelected) {
                { Icon(Icons.Default.Done, contentDescription = null, modifier = Modifier.size(FilterChipDefaults.IconSize)) }
            } else null
        )

        InputChip(
            onClick = {
                enabled = !enabled
            },
            label = { Text("InputChip") },
            selected = enabled,
            avatar = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            }
        )
        SuggestionChip(
            onClick = {  },
            label = { Text("SuggestionChip") }
        )


    }
}

@Preview
@Composable
fun PreviewChips(){
    Scaffold { ChipsScreen() }
}
