package com.example.groceryapp.screens.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, val icon: ImageVector?, var title: String) {
    data object Home : NavigationItem("home_screen", Icons.Rounded.Home, "Home")
    data object Cart : NavigationItem("Cart", Icons.Rounded.ShoppingCart, "Cart")
    data object Profile : NavigationItem("Profile", Icons.Rounded.AccountCircle, "Profile")
}