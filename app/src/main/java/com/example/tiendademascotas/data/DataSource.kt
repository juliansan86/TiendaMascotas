package com.example.tiendademascotas.data

import com.example.tiendademascotas.model.CareTip
import com.example.tiendademascotas.model.Pet
import com.example.tiendademascotas.model.Product

/**
 * Proveedor de datos estáticos para la aplicación.
 * En una app real, estos datos podrían venir de una API o Base de Datos.
 */
object DataSource {
    // Lista de productos para el catálogo
    val products = listOf(
        Product(1, "Comida para Perros", "Alimento balanceado para perros adultos de razas medianas.", 25.50, "https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg"),
        Product(2, "Juguete Masticable", "Juguete de goma resistente para perros de todos los tamaños.", 12.00, "https://images.pexels.com/photos/4588047/pexels-photo-4588047.jpeg"),
        Product(3, "Cama para Gatos", "Cama suave y acogedora para gatos y perros pequeños.", 45.00, "https://images.pexels.com/photos/774731/pexels-photo-774731.jpeg"),
        Product(4, "Shampoo para Mascotas", "Shampoo hipoalergénico con aroma a lavanda.", 15.75, "https://images.pexels.com/photos/4587979/pexels-photo-4587979.jpeg")
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
        CareTip(2, "Higiene Felina", "Cómo mantener a tu gato limpio y saludable.", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3"),
        CareTip(3, "Ejercicio para Perros", "La importancia del paseo diario para tu mascota.", "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3")
    )
}
