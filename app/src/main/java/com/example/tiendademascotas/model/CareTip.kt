package com.example.tiendademascotas.model

/**
 * Representa un consejo de cuidado de mascotas con video de YouTube.
 * @property id Identificador único.
 * @property videoId ID del video de YouTube.
 */
data class CareTip(
    val id: Int,
    val videoId: String
)
