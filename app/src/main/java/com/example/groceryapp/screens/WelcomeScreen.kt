package com.example.groceryapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryapp.R
import com.example.groceryapp.ui.theme.app_green
import com.example.groceryapp.ui.theme.text_gray

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.ic_welcome_bg),
                contentScale = ContentScale.FillBounds
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 95.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = CircleShape)
                    .size(66.dp),
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(width = 40.dp, height = 40.dp),
                    painter = painterResource(id = R.drawable.ic_app_logo),
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 36.dp),
                text = "Get your groceries delivered to your home",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 36.dp, vertical = 20.dp),
                text = "The best delivery app in town for delivering your daily fresh groceries",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = text_gray
            )
        }

        Button(
            modifier = Modifier
                .align(Alignment.Center)
                .size(190.dp, 55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = app_green),
            onClick = {

            }) {
            Text(
                text = "Shop now",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}