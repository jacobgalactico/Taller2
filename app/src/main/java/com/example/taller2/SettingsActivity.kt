package com.example.taller2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(onNavigateBack: () -> Unit) {
    var backgroundColor by remember { mutableStateOf(Color.White) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Configuración", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Botones para cambiar el color de fondo
        Button(onClick = { backgroundColor = Color.Yellow }) {
            Text("Cambiar color a Amarillo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { backgroundColor = Color.Cyan }) {
            Text("Cambiar color a Cian")
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Botón para volver a la pantalla de inicio
        Button(onClick = onNavigateBack) {
            Text("Volver a la pantalla de inicio")
        }
    }
}
