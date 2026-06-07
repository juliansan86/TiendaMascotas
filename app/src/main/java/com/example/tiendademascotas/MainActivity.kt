package com.example.tiendademascotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tiendademascotas.navigation.AppNavigation
import com.example.tiendademascotas.ui.theme.TiendadeMascotasTheme
import com.example.tiendademascotas.ui.viewmodel.PetViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Obtenemos el ViewModel para controlar el estado del tema
            val petViewModel: PetViewModel = viewModel()
            
            TiendadeMascotasTheme(darkTheme = petViewModel.isDarkMode) {
                AppNavigation(petViewModel = petViewModel)
            }
        }
    }
}
