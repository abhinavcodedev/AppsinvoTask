package com.example.walkintask.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walkintask.R
import com.example.walkintask.ui.theme.PrimaryColor
import com.example.walkintask.ui.theme.WalkInTaskTheme
import com.example.walkintask.ui.theme.WalkInTypography

@Composable
fun HomeToolbar(
    modifier: Modifier = Modifier,
    location: String = "Noida",
    onSearchClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Location
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(R.drawable.location),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = location,
                    modifier = Modifier.padding(start = 3.dp),
                    color = PrimaryColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = WalkInTypography.bodySmall
                )
            }
            // Logo
            Image(
                painter = painterResource(R.drawable.ic_logo_color),
                contentDescription = "Walkin Logo",
                modifier = Modifier
                    .height(40.dp)
                    .weight(1f),
                contentScale = ContentScale.Fit
            )
            // Actions
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.vector_smart_object_6),
                    contentDescription = "Search",
                    modifier = Modifier.size(18.dp)
                )
                Image(
                    painter = painterResource(R.drawable.vector_smart_object_7),
                    contentDescription = "Notification",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(18.dp)
                )
            }
        }
    }
}

@Preview(name = "Home Toolbar", showBackground = true,)
@Composable
private fun HomeToolbarPreview() {
    WalkInTaskTheme {
        HomeToolbar(
            location = "Noida"
        )
    }
}