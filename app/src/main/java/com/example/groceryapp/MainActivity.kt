package com.example.groceryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.groceryapp.screens.HomeScreen
import com.example.groceryapp.screens.ItemDetailsScreen
import com.example.groceryapp.screens.LoginScreen
import com.example.groceryapp.screens.SeeAllScreen
import com.example.groceryapp.screens.SplashScreen
import com.example.groceryapp.ui.theme.GroceryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "splash_screen"
                    ) {
                        composable("splash_screen") {
                            SplashScreen(navController = navController)
                        }
                        composable("Login") {
                            LoginScreen(navController = navController)
                        }
                        composable("home_screen") {
                            HomeScreen(navController = navController)
                        }
                        composable("see_all") {
                            SeeAllScreen(navController = navController)
                        }
                        composable("item_details"){
                            ItemDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}
