package com.example.groceryapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.ui.theme.app_green
import com.example.groceryapp.ui.theme.bg_light_green
import com.example.groceryapp.ui.theme.text_gray

@Composable
fun LoginScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Surface(
            shadowElevation = 4.dp, shape = CircleShape,
            modifier = Modifier.padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
                    .size(44.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_left_arrow),
                    contentDescription = ""
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(color = bg_light_green, shape = CircleShape)
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
                text = "Enter your mobile number",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 36.dp, vertical = 20.dp),
                text = "We will send you a verification code",
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = text_gray
            )

            var text by remember { mutableStateOf(TextFieldValue("+44")) }
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                textStyle = TextStyle(fontSize = 24.sp),
                placeholder = { Text("Enter your text here") },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                )
            )

            Button(
                modifier = Modifier
                    .padding(top = 60.dp)
                    .size(340.dp, 55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = app_green),
                onClick = {
                    navController.navigate("home_screen")
                }) {
                Text(
                    text = "Continue",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            val tcText = buildAnnotatedString {
                withStyle(style = SpanStyle(color = text_gray)) {
                    append("By clicking on “Continue” you are agreeing to our")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append(" terms of use")
                }
            }

            Text(
                modifier = Modifier.padding(horizontal = 35.dp, vertical = 20.dp),
                text = tcText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = text_gray,
                textAlign = TextAlign.Center
            )
        }

    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}