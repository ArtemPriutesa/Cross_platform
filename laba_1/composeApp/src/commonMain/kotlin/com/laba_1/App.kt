package com.laba_1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import laba_1.composeapp.generated.resources.Res
import laba_1.composeapp.generated.resources.compose_multiplatform




@Composable
@Preview
fun App() {
    Text(
        text = "Hello world",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Yellow)


    )
}
@Composable
@Preview
fun Form(){
    var name by remember { mutableStateOf("") }
    var surName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }


    // 2. Контейнер для розміщення елементів
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp), // Відступи між елементами
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Реєстрація", style = MaterialTheme.typography.headlineMedium)

        // 3. Текстові поля
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ваше ім'я") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = surName,
            onValueChange = { surName = it },
            label = { Text("Ваще прізвище") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )



        Spacer(modifier = Modifier.height(16.dp))

        // 4. Кнопка дії
        Button(
            onClick = {
                // Обробка даних (наприклад, лог або перевірка)
                println("User: $name $surName, Email: $email")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Відправити")
        }
    }
}
