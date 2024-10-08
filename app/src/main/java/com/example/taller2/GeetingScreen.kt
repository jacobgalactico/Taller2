package com.example.taller2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun GreetingScreen(onNavigate: () -> Unit) {
    // Obtener el saludo personalizado basado en la hora del día
    val greeting = getGreetingMessage()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = greeting, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        // Botón para ir a la pantalla principal
        Button(onClick = onNavigate) {
            Text("Ir a la actividad principal")
        }
    }
}

// Función para generar el saludo según la hora del día
fun getGreetingMessage(): String {
    val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when {
        currentHour in 0..11 -> "Buenos días"
        currentHour in 12..17 -> "Buenas tardes"
        else -> "Buenas noches"
    }
}
