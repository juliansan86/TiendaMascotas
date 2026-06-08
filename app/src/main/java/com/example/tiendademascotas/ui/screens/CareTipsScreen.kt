package com.example.tiendademascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tiendademascotas.model.CareTip
import com.example.tiendademascotas.ui.components.ExoVideoPlayer

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
        val configuration = LocalConfiguration.current
        val columns = if (configuration.screenWidthDp > 600) 3 else 1

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
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
        Column {
            Text(
                text = tip.description,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            ExoVideoPlayer(videoUrl = tip.videoUrl)
        }
    }
}
