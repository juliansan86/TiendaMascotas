package com.example.tiendademascotas.model

/**
 * Representa un consejo de cuidado de mascotas con video.
 * @property id Identificador único.
 * @property description Descripción del consejo.
 * @property videoUrl URL o ID del video.
 */
data class CareTip(
    val id: Int,
    val description: String,
    val videoUrl: String
)
