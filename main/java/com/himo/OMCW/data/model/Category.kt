package com.himo.OMCW.data.model

data class Category(
    val id: String,
    val name: String,
    val icon: String,
    val description: String
)

data class CategoriesData(
    val categories: List<Category>
)
