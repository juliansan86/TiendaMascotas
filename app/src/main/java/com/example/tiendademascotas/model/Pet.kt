package com.example.tiendademascotas.model

/**
 * Representa una mascota disponible en la galería.
 * @property id Identificador único.
 * @property name Nombre de la mascota.
 * @property type Especie o raza.
 * @property description Historia o detalles de la mascota.
 * @property imageUrl URL de la fotografía.
 * @property videoUrl URL opcional del video de la mascota.
 */
data class Pet(
    val id: Int,
    val name: String,
    val type: String,
    val description: String,
    val imageUrl: String,
    val videoUrl: String? = null
)
