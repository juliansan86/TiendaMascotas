package com.example.tiendademascotas.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

/**
 * Componente que integra ExoPlayer para reproducir videos.
 * Utiliza AndroidView para renderizar la vista clásica de PlayerView dentro de Compose.
 */
@Composable
fun VideoPlayer(videoUrl: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    
    // Inicialización de ExoPlayer recordada durante la recomposición
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(videoUrl))
            prepare()
        }
    }

    // Gestiona el ciclo de vida del reproductor para liberar recursos
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    // Integración de la vista de video de Media3
    AndroidView(
        factory = {
            PlayerView(context).apply {
                player = exoPlayer
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}
