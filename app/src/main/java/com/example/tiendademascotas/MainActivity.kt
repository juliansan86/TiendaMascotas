package com.example.tiendademascotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tiendademascotas.navigation.AppNavigation
import com.example.tiendademascotas.ui.theme.TiendadeMascotasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TiendadeMascotasTheme {
                AppNavigation()
            }
        }
    }
}
