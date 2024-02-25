package com.example.groceryapp.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.R
import com.example.groceryapp.screens.navigation.NavigationItem
import com.example.groceryapp.ui.theme.app_green
import com.example.groceryapp.ui.theme.app_red
import com.example.groceryapp.ui.theme.bg_light_gray
import com.example.groceryapp.ui.theme.bg_light_green
import com.example.groceryapp.ui.theme.text_gray

@Composable
fun HomeScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = bg_light_gray)
    ) {
        Column {
            ProfileBar()
            SearchBar()
            OffersList()
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(vertical = 20.dp)
            ) {
                CategoryList(navController)
                BestSellingList()
            }
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomNavigationBar(navController = rememberNavController())
        }
    }

}

@Composable
fun ProfileBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_avatar),
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f)
        ) {
            Text(
                text = "Good Morning", fontSize = 12.sp,
                color = text_gray
            )
            Text(
                text = "Pradeep Deshmukh", fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(50)
                )
                .padding(vertical = 6.dp, horizontal = 10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "",
                    tint = app_green
                )
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "My Flat",
                    fontSize = 12.sp
                )
                Icon(
                    modifier = Modifier
                        .rotate(-90f),
                    painter = painterResource(id = R.drawable.ic_left_arrow),
                    contentDescription = "",
                    tint = text_gray
                )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    SearchBar(
        modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
        query = "",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        colors = SearchBarDefaults.colors(
            containerColor = Color.White
        ),
        placeholder = { Text(text = "Search category", color = text_gray) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "",
                tint = app_green
            )
        }
    ) {

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OffersList() {
    val lazyListState = rememberLazyListState(
        initialFirstVisibleItemIndex = 1,
        initialFirstVisibleItemScrollOffset = -70
    )
    val snapBehaviour = rememberSnapFlingBehavior(lazyListState = lazyListState)
    LazyRow(
        modifier = Modifier
            .padding(vertical = 8.dp),
        state = lazyListState,
        flingBehavior = snapBehaviour
    ) {
        for (i in 0..5) {
            item {
                Card(
                    modifier = Modifier
                        .size(width = 340.dp, height = 160.dp)
                        .paint(
                            painterResource(id = R.drawable.img_ad)
                        )
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.img_ad),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryList(navController: NavController) {
    Column {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Categories",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Text(text = "See all", color = app_green)
        }

        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CategoryItem(
                resId = R.drawable.ic_apple,
                name = "Fruits"
            ) {
                navController.navigate("see_all")
            }
            CategoryItem(
                resId = R.drawable.ic_broccoli,
                name = "Vegetables"
            ) {
                navController.navigate("see_all")
            }
            CategoryItem(
                resId = R.drawable.ic_cheese,
                name = "Dairy"
            ) {}
            CategoryItem(
                resId = R.drawable.ic_meat,
                name = "Meat"
            ) {}
        }
    }
}

@Composable
fun CategoryItem(
    resId: Int,
    name: String,
    onClick: () -> Unit
) {
    Column {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(73.dp)
                .background(color = bg_light_gray, shape = CircleShape)
                .clickable {
                    onClick.invoke()
                },
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = resId), contentDescription = "")
        }
        Text(
            text = name,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun BestSellingList() {
    Column(modifier = Modifier.padding(top = 25.dp)) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Best selling",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Text(text = "See all", color = app_green)
        }

        LazyRow(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            item {
                BestSellingItem(
                    resId = R.drawable.img_paperica,
                    "Bell Pepper Red",
                    "1kg 4$"
                ) {}
            }
            item { BestSellingItem(resId = R.drawable.img_ginger, "Ginger", "1kg 4$") {} }
            item {
                BestSellingItem(
                    resId = R.drawable.img_paperica,
                    "Bell Pepper Red",
                    "1kg 4$"
                ) {}
            }
            item { BestSellingItem(resId = R.drawable.img_ginger, "Ginger", "1kg 4$") {} }
            item {
                BestSellingItem(
                    resId = R.drawable.img_paperica,
                    "Bell Pepper Red",
                    "1kg 4$"
                ) {}
            }
            item { BestSellingItem(resId = R.drawable.img_ginger, "Ginger", "1kg 4$") {} }
        }
    }
}

@Composable
fun BestSellingItem(
    resId: Int,
    name: String,
    priceAndQuantity: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clickable {
                onClick.invoke()
            }
            .padding(start = 8.dp, end = 8.dp)
            .size(width = 160.dp, height = 214.dp),
        colors = CardDefaults.cardColors(containerColor = bg_light_gray),
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.align(Alignment.Center)) {
                Image(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(width = 114.dp, height = 98.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = resId), contentDescription = ""
                )
                Text(
                    text = name, modifier = Modifier
                        .padding(top = 20.dp, bottom = 6.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = priceAndQuantity,
                    modifier = Modifier
                        .align(alignment = Alignment.Start),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = app_red,
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(6.dp)
                    .size(36.dp)
                    .background(color = app_green, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.ic_pluse), contentDescription = "")
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Cart,
        NavigationItem.Profile,
    )
    var selectedItem by remember { mutableStateOf(0) }
    var currentRoute by remember { mutableStateOf(NavigationItem.Home.route) }

    items.forEachIndexed { index, navigationItem ->
        if (navigationItem.route == currentRoute) {
            selectedItem = index
        }
    }
    NavigationBar(containerColor = Color.White, modifier = Modifier.height(64.dp)) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                alwaysShowLabel = true,
                icon = { Icon(item.icon!!, contentDescription = item.title, tint = Color.Gray) },
                label = { Text(item.title) },
                selected = selectedItem == index,
                colors = NavigationBarItemDefaults.colors(indicatorColor = bg_light_green),
                onClick = {
                    selectedItem = index
                    currentRoute = item.route
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}