package com.example.composablescenery.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.composablescenery.scene.ColorBoxesScene

private val colorRed = Color(0xFFFF8080)
private val colorGreen = Color(0xFFC6EBC9)
private val colorBlue = Color(0xFFAEE2FF)
private val colorPurple = Color(0xFFBA94D1)
private val colorPink = Color(0xFFFFB9B9)
private val colorYellow = Color(0xFFFAF4B7)
private val colorOrange = Color(0xFFF6AE99)

private val colors: List<Pair<Color, Color>> = listOf(
    colorRed to colorGreen,
    colorBlue to colorYellow,
    colorPurple to colorOrange,
    colorGreen to colorPink
)

@Composable
fun ColorBoxesScreen() {
    ColorBoxesScene(
        colors = colors,
        columns = 7,
        rows = 3,
    )
}