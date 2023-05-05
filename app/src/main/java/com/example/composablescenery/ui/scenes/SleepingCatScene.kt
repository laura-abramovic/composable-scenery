package com.example.composablescenery.ui.scenes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composablescenery.R
import com.example.composablescenery.ui.theme.ComposableSceneryTheme

@Composable
fun SleepingCatScene() {
    var isLightOn by remember { mutableStateOf(false) }

    val (switch, cat) = if (isLightOn) {
        R.drawable.ic_light_switch_on to R.drawable.cat_awake
    } else {
        R.drawable.ic_light_switch_off to R.drawable.cat_sleeping
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Icon(
            painter = painterResource(id = R.drawable.ic_ceiling_light),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(200.dp)
                .offset(y = (-40).dp)
        )

        val interactionSource = remember { MutableInteractionSource() }

        Icon(
            painter = painterResource(id = switch),
            contentDescription = "Light switch",

            modifier = Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { isLightOn = !isLightOn }
                .size(80.dp)
                .align(Alignment.CenterEnd)
        )

        Image(
            painter = painterResource(id = cat),
            contentDescription = null,
            modifier = Modifier
                .size(220.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
private fun LightOnScenePreview() = ComposableSceneryTheme {
    SleepingCatScene()
}