package com.example.groceryapp.screens

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.groceryapp.ui.theme.text_gray

@Composable
fun ItemDetailsScreen() {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.background(color = Color.White)) {
            Column(modifier = Modifier.background(color = bg_light_gray)) {
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

                    Spacer(modifier = Modifier.weight(1f))

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
                                imageVector = Icons.Default.Search,
                                contentDescription = ""
                            )
                        }
                    }
                }
                Image(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(250.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.img_ginger_big),
                    contentDescription = ""
                )
            }

            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Ginger",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
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
                            text = "4",
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
                Text(
                    text = "1kg, 4$",
                    modifier = Modifier
                        .align(alignment = Alignment.Start),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = app_red,
                )

                Text(
                    text = "Ginger is a flowering plant whose rhizome, ginger root or ginger, is widely used as a spice and a folk medicine.",
                    modifier = Modifier.padding(top = 6.dp),
                    color = text_gray,
                    fontSize = 16.sp
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
            ) {
                itemCategoryDetails(
                    img = R.drawable.ic_organic,
                    value = "100%",
                    type = "Organic",
                    modifier = Modifier
                        .size(167.dp, 67.dp)
                        .weight(1f)
                )
                Spacer(modifier = Modifier.size(16.dp))
                itemCategoryDetails(
                    img = R.drawable.ic_cal_1_year,
                    value = "100%",
                    type = "Organic",
                    modifier = Modifier
                        .size(167.dp, 67.dp)
                        .weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
            ) {
                itemCategoryDetails(
                    img = R.drawable.ic_star,
                    value = "100%",
                    type = "Organic",
                    modifier = Modifier
                        .size(167.dp, 67.dp)
                        .weight(1f)
                )
                Spacer(modifier = Modifier.size(16.dp))
                itemCategoryDetails(
                    img = R.drawable.ic_kal,
                    value = "100%",
                    type = "Organic",
                    modifier = Modifier
                        .size(167.dp, 67.dp)
                        .weight(1f)
                )
            }

            Button(
                modifier = Modifier
                    .padding(top = 60.dp)
                    .size(340.dp, 55.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = app_green),
                onClick = {

                }) {
                Text(
                    text = "Add to cart",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun itemCategoryDetails(
    img: Int,
    value: String,
    type: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, bg_light_gray)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = img),
                    contentDescription = ""
                )
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(
                        text = value,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = app_green
                    )
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(
                        text = type,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = text_gray
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun ItemDetailsScreenPreview() {
    ItemDetailsScreen()
}