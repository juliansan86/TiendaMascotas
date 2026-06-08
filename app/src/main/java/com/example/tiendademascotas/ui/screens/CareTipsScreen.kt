package com.example.tiendademascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tiendademascotas.model.CareTip
import com.example.tiendademascotas.ui.components.VideoPlayer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CareTipsScreen(
    tips: List<CareTip>
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Cuidados de Mascotas (Video)") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(tips) { tip ->
                CareTipItem(tip = tip)
            }
        }
    }
}

@Composable
fun CareTipItem(tip: CareTip) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        VideoPlayer(videoId = tip.videoId)
    }
}
