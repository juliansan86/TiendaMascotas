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

    // Lista de mascotas para la galería
    val pets = listOf(
        Pet(1, "Buddy", "Perro", "Un Golden Retriever juguetón y amigable.", "https://images.pexels.com/photos/2253275/pexels-photo-2253275.jpeg", "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
        Pet(2, "Misty", "Gato", "Una gata curiosa que ama las caricias.", "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg", "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4"),
        Pet(3, "Rex", "Perro", "Un pastor alemán leal y protector.", "https://images.pexels.com/photos/164186/pexels-photo-164186.jpeg", "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
    )

    // Lista de consejos de cuidado con audio
    val careTips = listOf(
        CareTip(1, "Cuidado del Cachorro", "Consejos básicos sobre la alimentación y socialización de tu cachorro.", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"),
        CareTip(2, "Higiene Felina", "Cómo mantener a tu gato limpio y saludable.", "https://open.spotify.com/episode/3RLNXiOFGMHkgUAmeAIDsH?si=05d354aa8d9e46a7"),
        CareTip(3, "Ejercicio para Perros", "La importancia del paseo diario para tu mascota.", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3")
    )
}
