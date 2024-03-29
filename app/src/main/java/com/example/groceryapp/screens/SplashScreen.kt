package com.example.groceryapp.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.ui.theme.app_green
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(targetValue = 0.7f, animationSpec = tween(durationMillis = 800, easing = {
            OvershootInterpolator(4f).getInterpolation(it)
        }))
        delay(1000L)
        navController.navigate("Login")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = app_green)
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.White, shape = CircleShape)
                .align(Alignment.Center)
                .size(110.dp)
        ) {
            Image(
                modifier = Modifier
                    .scale(scale = scale.value)
                    .align(Alignment.Center)
                    .size(width = 67.dp, height = 55.dp),
                painter = painterResource(id = R.drawable.ic_app_logo),
                contentDescription = ""
            )
        }
    }
}


@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}