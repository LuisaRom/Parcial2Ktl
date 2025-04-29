package com.example.tienda.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TiendaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = VerdeOscuro,
            secondary = Naranja,
            background = Color.Black,
            surface = Color.DarkGray,
            onPrimary = Color.White,
            onSecondary = Color.Black,
            error = RojoError
        )
    } else {
        lightColorScheme(
            primary = VerdeTienda,
            secondary = Naranja,
            background = FondoClaro,
            surface = Color.White,
            onPrimary = Color.White,
            onSecondary = Color.Black,
            error = RojoError
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
