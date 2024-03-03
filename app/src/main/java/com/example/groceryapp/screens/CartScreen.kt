package com.example.groceryapp.screens

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceryapp.R
import com.example.groceryapp.ui.theme.app_green
import com.example.groceryapp.ui.theme.app_red
import com.example.groceryapp.ui.theme.bg_light_gray

@Composable
fun CartScreen() {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shadowElevation = 4.dp, shape = CircleShape,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clickable {
                                onBackPressedDispatcher?.onBackPressed()
                            }
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
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Cart",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                )

            }

            CartItem(
                img = R.drawable.img_paperica,
                name = "Bell Papper Red",
                price = "1kg, 6$",
                quantity = 2
            )
            CartItem(img = R.drawable.img_ginger, name = "Ginger", price = "1kg, 4$", quantity = 4)
            CartItem(img = R.drawable.ic_meat, name = "Meat", price = "1kg, 8$", quantity = 1)
        }

        Button(
            modifier = Modifier
                .padding(vertical = 24.dp)
                .size(340.dp, 55.dp)
                .align(alignment = Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(containerColor = app_green),
            onClick = {

            }) {
            Text(
                text = "Checkout",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun CartItem(
    img: Int,
    name: String,
    price: String,
    quantity: Int
) {
    Row(
        modifier = Modifier
            .border(
                border = BorderStroke(1.dp, bg_light_gray),
                shape = RoundedCornerShape(4.dp)
            )
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = img), contentDescription = ""
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp)
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = price,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = app_red,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .size(36.dp)
                    .background(color = bg_light_gray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_pluse),
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = "$quantity",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .size(36.dp)
                    .background(color = app_green, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_pluse),
                    contentDescription = ""
                )
            }
        }

    }
}

@Preview
@Composable
fun CartScreenPreview() {
    CartScreen()
}