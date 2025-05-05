package com.cristinacabral.treasurehuntgameapp.ui.basescreen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BaseScreen(content: @Composable BoxScope.() -> Unit) {
    // Animate gradient shift
    val infiniteTransition = rememberInfiniteTransition(label = "backgroundAnimation")
    val offset = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 10000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "offset"
    )

    val animatedGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFB2EBF2),
            Color(0xFF80DEEA),
            Color(0xFF4DD0E1)
        ),
        startY = offset.value,
        endY = offset.value + 1000f
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(animatedGradient)
            .padding(16.dp)
    ) {
        content()
    }
}