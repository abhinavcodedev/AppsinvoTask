package com.example.walkintask.navigation

sealed class Screen(
    val route: String
) {
    data object Booking : Screen("booking")
    data object ScanQr : Screen("scan_qr")
    data object Home : Screen("home")
    data object Qr : Screen("qr")
    data object Profile : Screen("profile")
}