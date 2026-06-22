package com.example.walkintask.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.walkintask.ui.screens.booking.BookingScreen
import com.example.walkintask.ui.screens.home.HomeScreen
import com.example.walkintask.ui.screens.profile.ProfileScreen
import com.example.walkintask.ui.screens.OrCode.QrScreen
import com.example.walkintask.ui.screens.ScanQr.ScanQrScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Booking.route) { BookingScreen() }
        composable(Screen.ScanQr.route) { ScanQrScreen() }
        composable(Screen.Qr.route) { QrScreen() }
        composable(Screen.Profile.route) { ProfileScreen() }
    }
}