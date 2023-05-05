package com.example.composablescenery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composablescenery.ui.scenes.SleepingCatScene
import com.example.composablescenery.ui.theme.ComposableSceneryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableSceneryTheme {
                SleepingCatScene()
            }
        }
    }
}
