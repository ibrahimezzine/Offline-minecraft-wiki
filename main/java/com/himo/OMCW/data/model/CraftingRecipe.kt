package com.himo.OMCW.data.model

data class CraftingRecipe(
    val id: String,
    val result: String,
    val resultCount: Int = 1,
    val type: RecipeType,
    val pattern: List<List<String?>>,
    val shapeless: Boolean = false,
    val experience: Float = 0.0f
)

enum class RecipeType {
    CRAFTING,
    SMELTING,
    SMOKING,
    BLASTING
}

data class RecipesData(
    val recipes: List<CraftingRecipe>
)
