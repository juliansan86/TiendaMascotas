package com.example.tiendademascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tiendademascotas.model.Pet
import com.example.tiendademascotas.ui.components.VideoPlayer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetGalleryScreen(
    pets: List<Pet>,
    onPetClick: (Pet) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Galería de Videos") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(pets) { pet ->
                PetVideoItem(pet = pet, onClick = { onPetClick(pet) })
            }
        }
    }
}

@Composable
fun PetVideoItem(pet: Pet, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        VideoPlayer(videoId = pet.videoUrl)
    }
}
