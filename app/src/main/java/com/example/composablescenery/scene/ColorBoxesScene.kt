package com.example.composablescenery.scene

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable
fun ColorBoxesScene(
    colors: List<Pair<Color, Color>>,
    columns: Int,
    rows: Int,
    modifier: Modifier = Modifier,
    duration: Int = 800
) {
    Column(modifier = modifier) {
        repeat(columns) { column ->
            Row(modifier = Modifier.weight(1f)) {
                repeat(rows) { row ->
                    val (startColor, endColor) = colors[(column + row).mod(colors.size)]

                    ColorBox(
                        startColor = startColor,
                        endColor = endColor,
                        duration = duration,
                        startDelay = (column + row) * 10,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                }
            }
        }
    }
}

@Composable
private fun ColorBox(
    startColor: Color,
    endColor: Color,
    duration: Int,
    modifier: Modifier = Modifier,
    startDelay: Int = 0,
    changeDelay: Long = 1000
) {
    var animateBackgroundColor by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = animateBackgroundColor) {
        delay(changeDelay)
        animateBackgroundColor = animateBackgroundColor.not()
    }

    val animatedColor by animateColorAsState(
        targetValue = if (animateBackgroundColor) startColor else endColor,
        animationSpec = tween(
            durationMillis = duration,
            delayMillis = startDelay,
            easing = LinearEasing
        ),
        label = "",
    )

    Box(
        modifier = modifier.drawBehind {
            drawRect(animatedColor)
        }
    )
}