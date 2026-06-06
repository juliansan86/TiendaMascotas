package com.example.tiendademascotas.model

/**
 * Representa un consejo de cuidado de mascotas con audio.
 * @property id Identificador único.
 * @property title Título del consejo.
 * @property description Breve explicación del contenido.
 * @property audioUrl URL del archivo de audio descriptivo.
 */
data class CareTip(
    val id: Int,
    val title: String,
    val description: String,
    val audioUrl: String
)
