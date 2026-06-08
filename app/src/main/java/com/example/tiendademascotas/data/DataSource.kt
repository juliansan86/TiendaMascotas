package com.example.tiendademascotas.data

import com.example.tiendademascotas.model.CareTip
import com.example.tiendademascotas.model.Pet
import com.example.tiendademascotas.model.Product

/**
 * Proveedor de datos estáticos para la aplicación con precios en Pesos Colombianos (COP).
 */
object DataSource {
    // Lista de productos para el catálogo categorizada
    val products = listOf(
        // Perros
        Product(1, "Comida para Perros", "Alimento balanceado para perros adultos.", 85000.0, "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg", "Perros"),
        Product(2, "Juguete Masticable", "Resistente para todas las tallas.", 35000.0, "https://images.pexels.com/photos/4588047/pexels-photo-4588047.jpeg", "Perros"),

        // Gatos
        Product(3, "Cama para Gatos", "Cama suave y acogedora.", 120000.0, "https://images.pexels.com/photos/774731/pexels-photo-774731.jpeg", "Gatos"),
        Product(4, "Arena Sanitaria", "Control de olores avanzado.", 45000.0, "https://origens.com.pe/wp-content/uploads/2025/05/vista-superior-de-accesorios-para-mascotas-scaled.jpg", "Gatos"),

        // Aves
        Product(5, "Jaula para Aves", "Espaciosa con accesorios incluidos.", 150000.0, "https://panel.artiani.com.mx/media/apps/ecommerce/productos/1487/1758503316.jpg", "Aves"),
        Product(6, "Mezcla de Semillas", "Nutrición completa para aves pequeñas.", 15000.0, "https://cdn.shopify.com/s/files/1/0012/3512/4273/collections/mayoreo_ALPISTE2.jpg?v=1617068769", "Aves"),

        // Peces
        Product(7, "Acuario de Cristal", "Capacidad de 20 litros con filtro.", 250000.0, "https://images.pexels.com/photos/3220368/pexels-photo-3220368.jpeg", "Peces"),
        Product(8, "Alimento en Hojuelas", "Potencia el color de tus peces.", 12000.0, "https://images.pexels.com/photos/128756/pexels-photo-128756.jpeg", "Peces")
    )

    // Sección: Mascotas Tiernas (Solo Videos)
    val cutePets = listOf(
        Pet(id = 1, videoUrl = "FO1K41xJNIM"),
        Pet(id = 2, videoUrl = "wv_dJvjuC04"),
        Pet(id = 3, videoUrl = "_Q_BZ172ST0")
    )

    // Sección: En Adopción y Compra (Solo Imágenes)
    val adoptionAndSalePets = listOf(
        Pet(
            id = 4,
            imageUrl = "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg",
            status = "En Adopción" // Perro
        ),
        Pet(
            id = 5,
            imageUrl = "https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg",
            status = "En Adopción" // Gato
        ),
        Pet(
            id = 6,
            imageUrl = "https://images.pexels.com/photos/3220368/pexels-photo-3220368.jpeg",
            status = "En Venta" // Peces
        ),
        Pet(
            id = 7,
            imageUrl = "https://images.pexels.com/photos/326012/pexels-photo-326012.jpeg",
            status = "En Venta" // Aves
        )
    )

    // Combinación para compatibilidad con el ViewModel (si se requiere)
    val pets = cutePets + adoptionAndSalePets

    // Lista de consejos de cuidado con videos de YouTube (solo videos)
    val careTips = listOf(
        CareTip(1, "J3NAYXXyBVI"),
        CareTip(2, "LZ9AKsUCcTI"),
        CareTip(3, "iZGingQsrHI")
    )
}
