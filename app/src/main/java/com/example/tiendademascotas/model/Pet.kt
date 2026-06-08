package com.example.tiendademascotas.model

/**
 * Representa una mascota disponible en la galería.
 * @property id Identificador único.
 * @property videoUrl ID del video de YouTube de la mascota (opcional).
 * @property imageUrl URL de la imagen de la mascota (opcional).
 * @property status Estado de la mascota (ej. "En Adopción", "En Venta", o null para mascotas tiernas).
 */
data class Pet(
    val id: Int,
    val videoUrl: String? = null,
    val imageUrl: String? = null,
    val status: String? = null
)
