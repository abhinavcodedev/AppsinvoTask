package com.example.walkintask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.walkintask.navigation.NavGraph
import com.example.walkintask.navigation.WalkInApp
import com.example.walkintask.ui.theme.WalkInTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalkInTaskTheme {
                WalkInApp()
            }
        }
    }
}