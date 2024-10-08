package com.example.taller2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController() // Controlador de navegación

    AppNavigation(navController) // Llamada al sistema de navegación
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "greeting_screen") {
        // Pantalla de inicio
        composable("greeting_screen") {
            GreetingScreen(onNavigate = { navController.navigate("main_screen") })
        }
        // Pantalla principal
        composable("main_screen") {
            MainScreen(onNavigateToSettings = { navController.navigate("settings_screen") })
        }
        // Pantalla de configuración
        composable("settings_screen") {
            SettingsScreen(onNavigateBack = { navController.navigate("greeting_screen") })
        }
    }
}
