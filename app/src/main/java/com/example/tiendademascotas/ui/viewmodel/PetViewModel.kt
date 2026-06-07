package com.example.tiendademascotas.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tiendademascotas.data.DataSource
import com.example.tiendademascotas.model.CareTip
import com.example.tiendademascotas.model.Pet
import com.example.tiendademascotas.model.Product

/**
 * ViewModel que gestiona la lógica de la aplicación siguiendo el patrón MVVM.
 * Utiliza DataSource para obtener datos locales estáticos.
 */
class PetViewModel : ViewModel() {

    // Estado para productos
    var products by mutableStateOf<List<Product>>(DataSource.products)
        private set

    // Estado para mascotas
    var pets by mutableStateOf<List<Pet>>(DataSource.pets)
        private set

    // Estado para consejos de cuidado
    var careTips by mutableStateOf<List<CareTip>>(DataSource.careTips)
        private set

    // Estado para el modo oscuro (controlado por el usuario)
    var isDarkMode by mutableStateOf(false)
        private set

    /**
     * Alterna entre modo claro y oscuro.
     */
    fun toggleDarkMode() {
        isDarkMode = !isDarkMode
    }
}
