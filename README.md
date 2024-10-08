# Taller2

Este proyecto es una aplicación de Android desarrollada en Kotlin utilizando Jetpack Compose. La aplicación incluye varias pantallas y funcionalidades básicas como navegación, temas dinámicos y tareas en segundo plano.

## Estructura del Proyecto

### `MainActivity.kt`

La actividad principal que inicializa la aplicación y configura la navegación.

### `GreetingScreen.kt`

Pantalla de saludo que muestra un mensaje basado en la hora del día y un botón para navegar a la pantalla principal.

### `MainScreenActivity.kt`

Pantalla principal que permite al usuario ingresar su nombre, iniciar una tarea en segundo plano y navegar a la pantalla de configuración.

### `SettingsActivity.kt`

Pantalla de configuración que permite al usuario cambiar el color de fondo y volver a la pantalla de inicio.


## Navegación

La navegación entre pantallas se maneja utilizando `NavHostController` y `NavHost` de Jetpack Compose. Las rutas de navegación incluyen:

- `greeting_screen`: Pantalla de saludo.
- `main_screen`: Pantalla principal.
- `settings_screen`: Pantalla de configuración.


## Tareas en Segundo Plano

La pantalla principal incluye una tarea en segundo plano simulada utilizando `AsyncTask`. La tarea actualiza un indicador de progreso en la interfaz de usuario.
