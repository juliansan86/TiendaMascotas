package com.example.tiendademascotas.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tiendademascotas.model.CareTip
import com.example.tiendademascotas.model.Pet
import com.example.tiendademascotas.model.Product
import com.example.tiendademascotas.network.RetrofitClient
import kotlinx.coroutines.launch

/**
 * ViewModel que gestiona la lógica de obtención de datos desde la API.
 * Mantiene el estado de la UI y gestiona los ciclos de vida de las corrutinas.
 */
class PetViewModel : ViewModel() {

    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    var pets by mutableStateOf<List<Pet>>(emptyList())
        private set

    var careTips by mutableStateOf<List<CareTip>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        fetchAllData()
    }

    /**
     * Llama a todos los endpoints de la API al iniciar el ViewModel.
     */
    fun fetchAllData() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                // Realizamos las llamadas en paralelo o secuencial
                products = RetrofitClient.instance.getProducts()
                pets = RetrofitClient.instance.getPets()
                careTips = RetrofitClient.instance.getCareTips()
            } catch (e: Exception) {
                errorMessage = "Error al conectar con el servidor: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}
