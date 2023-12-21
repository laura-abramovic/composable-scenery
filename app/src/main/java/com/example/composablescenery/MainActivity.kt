package com.example.composablescenery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composablescenery.scene.ColorBoxesScene
import com.example.composablescenery.screen.ColorBoxesScreen
import com.example.composablescenery.ui.theme.ComposableSceneryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableSceneryTheme {
                ColorBoxesScreen()
            }
        }
    }
}
