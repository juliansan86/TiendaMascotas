package com.example.tiendademascotas.model

/**
 * Representa un producto de la tienda de mascotas.
 * @property id Identificador único del producto.
 * @property name Nombre del producto.
 * @property description Descripción detallada.
 * @property price Precio del producto.
 * @property imageUrl URL de la imagen del producto.
 */
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val category: String
)
