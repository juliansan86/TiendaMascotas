package com.example.tiendademascotas.network

import com.example.tiendademascotas.model.CareTip
import com.example.tiendademascotas.model.Pet
import com.example.tiendademascotas.model.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Interfaz que define las llamadas a la API mediante Retrofit.
 */
interface PetApiService {
    @GET("products") // Endpoint para obtener productos
    suspend fun getProducts(): List<Product>

    @GET("pets") // Endpoint para obtener mascotas
    suspend fun getPets(): List<Pet>

    @GET("care-tips") // Endpoint para obtener consejos de cuidado
    suspend fun getCareTips(): List<CareTip>
}

/**
 * Cliente Retrofit para centralizar la configuración de la red.
 */
object RetrofitClient {
    // URL base de la API (Aquí pondrías la URL de tu servidor real o mock)
    private const val BASE_URL = "https://my-json-server.typicode.com/jas_9/TiendadeMascotas/"

    val instance: PetApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PetApiService::class.java)
    }
}
