package com.example.walkintask.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.walkintask.R
import com.example.walkintask.ui.theme.BgColor
import com.example.walkintask.ui.theme.Black
import com.example.walkintask.ui.theme.PrimaryColor
import com.example.walkintask.ui.theme.WalkInTaskTheme
import com.example.walkintask.ui.theme.WalkInTypography

@Composable
fun StaySafeCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color(0xFFEAF4FF)
        ),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Stay Safe",
                    modifier = Modifier.weight(1f),
                    color = PrimaryColor,
                    style = WalkInTypography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SafetyItem(
                    icon = R.drawable.vector_smart_object_3,
                    title = "Always wear a mask"
                )
                SafetyItem(
                    icon = R.drawable.vector_smart_object_2,
                    title = "Wash hand"
                )
                SafetyItem(
                    icon = R.drawable.vector_smart_object_1,
                    title = "Keep distance with other person"
                )
            }
        }
    }
}

@Composable
private fun SafetyItem(
    icon: Int,
    title: String
) {
    Column(
        modifier = Modifier.width(90.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = title,
            style = WalkInTypography.bodySmall,
            color = Black,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true,)
@Composable
private fun StaySafeCardPreview() {
    WalkInTaskTheme {
        StaySafeCard()
    }
}