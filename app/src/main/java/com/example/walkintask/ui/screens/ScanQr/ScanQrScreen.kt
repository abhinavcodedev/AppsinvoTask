package com.example.walkintask.ui.screens.ScanQr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.walkintask.R
import com.example.walkintask.ui.theme.White

@Composable
fun ScanQrScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(R.drawable.ic_empty),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScanQrScreenPreview() {
    ScanQrScreen()
}