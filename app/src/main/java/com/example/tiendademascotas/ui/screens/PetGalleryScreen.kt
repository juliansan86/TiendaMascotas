package com.example.tiendademascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.tiendademascotas.model.Pet
import com.example.tiendademascotas.ui.components.VideoPlayer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetGalleryScreen(
    pets: List<Pet>,
    onPetClick: (Pet) -> Unit
) {
    // Dividimos la lista en las dos secciones solicitadas
    val cutePets = pets.filter { it.status == null }
    val adoptionAndSalePets = pets.filter { it.status != null }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Galería de Mascotas") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Sección: Mascotas Tiernas
            item {
                Text(
                    text = "Mascotas Tiernas",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(cutePets) { pet ->
                PetVideoCard(pet = pet, onClick = { onPetClick(pet) })
            }

            // Sección: En Adopción y Compra
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "En Adopción y Compra",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(adoptionAndSalePets) { pet ->
                PetAdoptionCard(pet = pet, onClick = { onPetClick(pet) })
            }
        }
    }
}

@Composable
fun PetVideoCard(pet: Pet, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        pet.videoUrl?.let { videoId ->
            VideoPlayer(videoId = videoId)
        }
    }
}

@Composable
fun PetAdoptionCard(pet: Pet, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
                AsyncImage(
                    model = pet.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                pet.status?.let { status ->
                    Surface(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier.padding(8.dp).align(Alignment.TopEnd)
                    ) {
                        Text(
                            text = status,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            // Los videos han sido removidos de esta sección según la solicitud
        }
    }
}
