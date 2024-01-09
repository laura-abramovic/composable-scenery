package com.example.composablescenery.scene

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composablescenery.ui.theme.Pink80

@Preview
@Composable
fun BouncyBallScene() {
    val infiniteTransition = rememberInfiniteTransition()

    val animationSpec = infiniteRepeatable<Float>(
        animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
        repeatMode = RepeatMode.Reverse
    )

    val animateScale = infiniteTransition.animateFloat(
        initialValue = 0.9f,
        targetValue = 1f,
        animationSpec = animationSpec
    )

    val animateTranslation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -1000f,
        animationSpec = animationSpec
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleY = animateScale.value
                    translationY = animateTranslation.value
                }
                .align(Alignment.BottomCenter)
                .size(100.dp)
                .background(Pink80, CircleShape)
        )
    }
}
