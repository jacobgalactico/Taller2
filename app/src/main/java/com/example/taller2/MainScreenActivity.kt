package com.example.taller2

import android.os.AsyncTask
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(onNavigateToSettings: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var inputName by remember { mutableStateOf("") }
    var isTaskRunning by remember { mutableStateOf(false) }
    var progress by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = inputName,
            onValueChange = { inputName = it },
            label = { Text("Ingresa tu nombre") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { name = inputName }) {
            Text("Guardar Nombre")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nombre ingresado: $name")

        Spacer(modifier = Modifier.height(16.dp))
        if (isTaskRunning) {
            LinearProgressIndicator(progress = progress / 100f)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            MyAsyncTask { p ->
                progress = p
                if (p == 100) {
                    isTaskRunning = false
                }
            }.execute()
            isTaskRunning = true
        }) {
            Text("Iniciar tarea en segundo plano")
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Botón para ir a la pantalla de configuración
        Button(onClick = onNavigateToSettings) {
            Text("Ir a la pantalla de configuración")
        }
    }
}

// AsyncTask que simula una tarea en segundo plano
class MyAsyncTask(val onProgressUpdate: (Int) -> Unit) : AsyncTask<Void, Int, Void>() {
    override fun doInBackground(vararg params: Void?): Void? {
        for (i in 1..100) {
            Thread.sleep(50) // Simulación de tarea
            publishProgress(i)
        }
        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        values[0]?.let { onProgressUpdate(it) }
    }
}
