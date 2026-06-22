package com.example.walkintask.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.walkintask.ui.component.CustomBottomBar

@Composable
fun WalkInApp() {

    val navController = rememberNavController()
    var selectedIndex by remember {
        mutableIntStateOf(2)
    }

    Scaffold(
        bottomBar = {
            CustomBottomBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index ->

                    if (selectedIndex == index) return@CustomBottomBar

                    selectedIndex = index

                    val route = when (index) {
                        0 -> Screen.Booking.route
                        1 -> Screen.ScanQr.route
                        2 -> Screen.Home.route
                        3 -> Screen.Qr.route
                        4 -> Screen.Profile.route
                        else -> Screen.Home.route
                    }
                    navController.navigate(route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    ) { padding ->
        NavGraph(
            navController = navController,
            modifier = Modifier.padding(padding)
        )
    }
}