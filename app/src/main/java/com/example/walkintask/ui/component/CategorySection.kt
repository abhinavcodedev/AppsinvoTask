package com.example.walkintask.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walkintask.R
import com.example.walkintask.model.Category
import com.example.walkintask.ui.theme.WalkInTaskTheme
@Composable
fun CategorySection(
    categories: List<Category>
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        categories.take(9).forEach { category ->
            CategoryCard(
                category = category,
                modifier = Modifier.width(105.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun CategoryCardPreview() {
    WalkInTaskTheme {
        CategoryCard(
            category = Category(
                id = 1,
                title = "Salon",
                imageResId = R.drawable.saloon
            )
        )
    }
}