package com.himo.OMCW.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himo.OMCW.data.model.CraftingRecipe
import com.himo.OMCW.data.model.RecipeType

@Composable
fun CraftingRecipeDisplay(recipe: CraftingRecipe) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = when (recipe.type) {
                RecipeType.CRAFTING -> if (recipe.shapeless) "Shapeless Crafting" else "Crafting"
                RecipeType.SMELTING -> "Smelting"
                RecipeType.SMOKING -> "Smoking"
                RecipeType.BLASTING -> "Blasting"
            },
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        when (recipe.type) {
            RecipeType.CRAFTING -> CraftingTableGrid(recipe)
            RecipeType.SMELTING, RecipeType.SMOKING, RecipeType.BLASTING -> FurnaceLayout(recipe)
        }
    }
}

@Composable
fun CraftingTableGrid(recipe: CraftingRecipe) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // Grid
        Column {
            val patternHeight = recipe.pattern.size
            val patternWidth = recipe.pattern.maxOfOrNull { it.size } ?: 0
            
            val isTwoByTwo = patternHeight <= 2 && patternWidth <= 2 && recipe.pattern.flatten().filterNotNull().size <= 4

            val gridSize = if (isTwoByTwo) 2 else 3

            for (i in 0 until gridSize) {
                Row {
                    for (j in 0 until gridSize) {
                        val itemId = recipe.pattern.getOrNull(i)?.getOrNull(j)
                        GridSlot(itemId = itemId)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.width(16.dp))
        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Yields", tint = MaterialTheme.colorScheme.onSurface)
        Spacer(modifier = Modifier.width(16.dp))

        // Result
        ResultSlot(itemId = recipe.result, count = recipe.resultCount)
    }
}

@Composable
fun FurnaceLayout(recipe: CraftingRecipe) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Input
            GridSlot(itemId = recipe.pattern.getOrNull(0)?.getOrNull(0))
            Spacer(modifier = Modifier.height(4.dp))
            Text("🔥", fontSize = 24.sp) // Fuel Emoji
            Spacer(modifier = Modifier.height(4.dp))
        }
        Spacer(modifier = Modifier.width(16.dp))
        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Yields")
        Spacer(modifier = Modifier.width(16.dp))

        // Result
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ResultSlot(itemId = recipe.result, count = recipe.resultCount)
            if (recipe.experience > 0) {
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⭐", fontSize = 16.sp) // Star Emoji
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${recipe.experience} XP",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}


@Composable
fun GridSlot(itemId: String?) {
    val context = LocalContext.current
    val drawableId = remember(itemId) {
        if (itemId == null) 0 else context.resources.getIdentifier(
            itemId,
            "drawable",
            context.packageName
        )
    }

    val emptyColor = if (isSystemInDarkTheme()) Color(0xFF424242) else Color(0xFFE0E0E0)
    val slotColor = if (itemId != null) MaterialTheme.colorScheme.surface else emptyColor

    Box(
        modifier = Modifier
            .size(48.dp)
            .background(slotColor, shape = MaterialTheme.shapes.small)
            .border(1.dp, Color.Gray.copy(alpha = 0.5f), shape = MaterialTheme.shapes.small),
        contentAlignment = Alignment.Center
    ) {
        if (drawableId != 0) {
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = itemId,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}

@Composable
fun ResultSlot(itemId: String, count: Int) {
    val context = LocalContext.current
    val drawableId = remember(itemId) {
        context.resources.getIdentifier(itemId, "drawable", context.packageName)
    }

    Box(
        modifier = Modifier
            .size(56.dp)
            .background(MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.medium)
            .border(
                2.dp,
                MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.medium
            )
            .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        if (drawableId != 0) {
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = itemId,
                modifier = Modifier.size(48.dp)
            )
        }

        if (count > 1) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(2.dp)
                    .background(
                        Color.Black.copy(alpha = 0.6f),
                        shape = MaterialTheme.shapes.small
                    )
            ) {
                Text(
                    text = count.toString(),
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                )
            }
        }
    }
}