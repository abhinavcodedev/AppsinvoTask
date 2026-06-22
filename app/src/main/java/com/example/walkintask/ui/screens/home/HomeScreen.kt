package com.example.walkintask.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walkintask.model.Category
import com.example.walkintask.ui.component.BannerCard
import com.example.walkintask.ui.component.CategorySection
import com.example.walkintask.ui.component.HomeToolbar
import com.example.walkintask.ui.component.StaySafeCard
import com.example.walkintask.ui.theme.WalkInTaskTheme
import com.example.walkintask.ui.theme.White

@Composable
fun HomeScreen() {
    val categories = Category.getDummyList()
    var showStaySafe by remember { mutableStateOf(true) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        item {
            HomeToolbar()
            Spacer(modifier = Modifier.height(12.dp))
            BannerCard()
            Spacer(modifier = Modifier.height(18.dp))
            CategorySection(categories)
            Spacer(modifier = Modifier.height(18.dp))
            StaySafeCard()
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen(){
    WalkInTaskTheme {
        HomeScreen()
    }
}