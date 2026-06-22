package com.example.walkintask.model

import androidx.annotation.DrawableRes
import com.example.walkintask.R

data class Category(
    val id: Int,
    val title: String,
    @DrawableRes val imageResId: Int
) {
    companion object {

        fun getDummyList(): List<Category> {

            return listOf(
                Category(
                    1,
                    "Saloon",
                    R.drawable.saloon
                ),
                Category(
                    2,
                    "Retail",
                    R.drawable.ic_retail
                ),
                Category(
                    3,
                    "Malls",
                    R.drawable.mall
                ),
                Category(
                    4,
                    "Gym",
                    R.drawable.vector_smart_object_1_2
                ),
                Category(
                    5,
                    "Restaurant",
                    R.drawable.vector_smart_object_copy_3
                ),
                Category(
                    6,
                    "Grocery",
                    R.drawable.vector_smart_object_copy_3
                ),
                Category(
                    7,
                    "Saloon",
                    R.drawable.saloon
                ),
                Category(
                    8,
                    "Retail",
                    R.drawable.ic_retail
                ),
                Category(
                    9,
                    "Malls",
                    R.drawable.mall
                )
            )
        }
    }
}