package com.example.tiendademascotas.model

/**
 * Representa una mascota disponible en la galería con su video de YouTube.
 * @property id Identificador único.
 * @property videoUrl ID del video de YouTube de la mascota.
 */
data class Pet(
    val id: Int,
    val videoUrl: String
)
