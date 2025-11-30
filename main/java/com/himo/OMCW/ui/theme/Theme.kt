package com.himo.OMCW.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.himo.OMCW.R
import com.himo.OMCW.viewmodel.ThemeMode
import com.himo.OMCW.viewmodel.ThemeStyle

@Composable
fun OfflineMinecraftWIKITheme(
    themeStyle: ThemeStyle = ThemeStyle.DEFAULT,
    themeMode: ThemeMode = ThemeMode.LIGHT,
    content: @Composable () -> Unit
) {
    val colorScheme = when (themeStyle) {
        ThemeStyle.DEFAULT -> if (themeMode == ThemeMode.DARK) DefaultDarkScheme else DefaultLightScheme
        ThemeStyle.OVERWORLD -> if (themeMode == ThemeMode.DARK) OverworldDarkScheme else OverworldLightScheme
        ThemeStyle.NETHER -> if (themeMode == ThemeMode.DARK) NetherDarkScheme else NetherLightScheme
        ThemeStyle.END -> if (themeMode == ThemeMode.DARK) EndDarkScheme else EndLightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun ThemedBackground(
    themeStyle: ThemeStyle,
    content: @Composable () -> Unit
) {
    // The base Box fills the screen.
    Box(
        modifier = Modifier
            .fillMaxSize()
            // The solid background color is applied first.
            .background(MaterialTheme.colorScheme.background)
    ) {
        // The tiled background image is drawn on top of the solid color,
        // but only for non-default themes.
        if (themeStyle != ThemeStyle.DEFAULT) {
            Image(
                painter = painterResource(id = getBackgroundImage(themeStyle)),
                contentDescription = null,
                contentScale = ContentScale.Crop, // Use Crop to fill, will be tiled by the painter
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.2f) // Set transparency for the image
            )
        }
        // The actual app content is placed on top of everything.
        content()
    }
}

/**
 * Returns the drawable resource ID for the background image based on the theme style.
 */
private fun getBackgroundImage(themeStyle: ThemeStyle): Int {
    return when (themeStyle) {
        ThemeStyle.OVERWORLD -> R.drawable.theme_overworld
        ThemeStyle.NETHER -> R.drawable.theme_nether
        ThemeStyle.END -> R.drawable.theme_end
        ThemeStyle.DEFAULT -> 0 // Should not happen, but return a placeholder
    }
}