package com.himo.OMCW.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Default Light Theme (Material 3 baseline)
val DefaultLightScheme = lightColorScheme(
    primary = Color(0xFF625B71),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFEADDFF),
    onPrimaryContainer = Color(0xFF1D192B),
    secondary = Color(0xFF625B71),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFE8DEF8),
    onSecondaryContainer = Color(0xFF1D192B),
    tertiary = Color(0xFF7D5260),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFFFD8E4),
    onTertiaryContainer = Color(0xFF31111D),
    error = Color(0xFFB3261E),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFF9DEDC),
    onErrorContainer = Color(0xFF410E0B),
    background = Color(0xFFFEF7FF),
    onBackground = Color(0xFF1D1B20),
    surface = Color(0xFFFEF7FF),
    onSurface = Color(0xFF1D1B20),
    surfaceVariant = Color(0xFFE7E0EC),
    onSurfaceVariant = Color(0xFF49454F),
    outline = Color(0xFF79747E),
    inverseOnSurface = Color(0xFFF5EFF7),
    inverseSurface = Color(0xFF322F35),
    inversePrimary = Color(0xFFD0BCFF)
)

// Default Dark Theme (Material 3 baseline)
val DefaultDarkScheme = darkColorScheme(
    primary = Color(0xFFD0BCFF),
    onPrimary = Color(0xFF381E72),
    primaryContainer = Color(0xFF4F378B),
    onPrimaryContainer = Color(0xFFEADDFF),
    secondary = Color(0xFFCCC2DC),
    onSecondary = Color(0xFF332D41),
    secondaryContainer = Color(0xFF4A4458),
    onSecondaryContainer = Color(0xFFE8DEF8),
    tertiary = Color(0xFFEFB8C8),
    onTertiary = Color(0xFF492532),
    tertiaryContainer = Color(0xFF633B48),
    onTertiaryContainer = Color(0xFFFFD8E4),
    error = Color(0xFFF2B8B5),
    onError = Color(0xFF601410),
    errorContainer = Color(0xFF8C1D18),
    onErrorContainer = Color(0xFFF9DEDC),
    background = Color(0xFF141218),
    onBackground = Color(0xFFE6E0E9),
    surface = Color(0xFF141218),
    onSurface = Color(0xFFE6E0E9),
    surfaceVariant = Color(0xFF49454F),
    onSurfaceVariant = Color(0xFFCAC4D0),
    outline = Color(0xFF938F99),
    inverseOnSurface = Color(0xFF1D1B20),
    inverseSurface = Color(0xFFE6E0E9),
    inversePrimary = Color(0xFF6750A4)
)

// Overworld Light Theme
val OverworldLightScheme = lightColorScheme(
    primary = Color(0xFF6BA83C),      // Grass Green
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFC8E6C9),
    onPrimaryContainer = Color(0xFF21360E),
    secondary = Color(0xFF8B6F47),    // Oak Brown
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFF5E2CF),
    onSecondaryContainer = Color(0xFF3A2A0E),
    tertiary = Color(0xFF87CEEB),      // Sky Blue
    onTertiary = Color(0xFF000000),
    tertiaryContainer = Color(0xFFD6F0FC),
    onTertiaryContainer = Color(0xFF003B4F),
    error = Color(0xFFFF6B35),        // Lava Orange
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD3),
    onErrorContainer = Color(0xFF662A14),
    background = Color(0xFF8B7355),  // Dirt Brown
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFFDCDCDC),      // Light Stone
    onSurface = Color(0xFF1C1C1C),
    surfaceVariant = Color(0xFFDEE5D9),
    onSurfaceVariant = Color(0xFF424940),
    outline = Color(0xFF727970)
)

// Overworld Dark Theme
val OverworldDarkScheme = darkColorScheme(
    primary = Color(0xFF4A7C2E),      // Dark Grass
    onPrimary = Color(0xFFE0E0E0),
    primaryContainer = Color(0xFF2E5218),
    onPrimaryContainer = Color(0xFFC8E6C9),
    secondary = Color(0xFF5C4A33),    // Dark Oak
    onSecondary = Color(0xFFE0E0E0),
    secondaryContainer = Color(0xFF423522),
    onSecondaryContainer = Color(0xFFF5E2CF),
    tertiary = Color(0xFF4682B4),      // Night Sky
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFF2B4E6C),
    onTertiaryContainer = Color(0xFFD6F0FC),
    error = Color(0xFFDC3545),        // Fire Red
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFF8B222B),
    onErrorContainer = Color(0xFFFFDAD3),
    background = Color(0xFF1A2F1A),  // Deep Dark Green
    onBackground = Color(0xFFE2E3DE),
    surface = Color(0xFF3A3A3A),      // Stone Gray
    onSurface = Color(0xFFEAEAEA),
    surfaceVariant = Color(0xFF424940),
    onSurfaceVariant = Color(0xFFC2C9BF),
    outline = Color(0xFF8C9389)
)

// Nether Light Theme
val NetherLightScheme = lightColorScheme(
    primary = Color(0xFFA0322C),      // Netherrack Red
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFDAD5),
    onPrimaryContainer = Color(0xFF410001),
    secondary = Color(0xFF5C4033),    // Soul Sand Brown
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFE0CDBA),
    onSecondaryContainer = Color(0xFF2B1C0D),
    tertiary = Color(0xFFFFD700),     // Glowstone Yellow
    onTertiary = Color(0xFF000000),
    tertiaryContainer = Color(0xFFFFF0B3),
    onTertiaryContainer = Color(0xFF332B00),
    error = Color(0xFFFF4500),        // Magma Orange
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDBCF),
    onErrorContainer = Color(0xFF5C1A00),
    background = Color(0xFFE8C4C4),  // Light Red
    onBackground = Color(0xFF2C1414),
    surface = Color(0xFF2C1414),      // Nether Brick
    onSurface = Color(0xFFE8C4C4),
    surfaceVariant = Color(0xFF534341),
    onSurfaceVariant = Color(0xFFD8C2BF),
    outline = Color(0xFFA08C8A)
)

// Nether Dark Theme
val NetherDarkScheme = darkColorScheme(
    primary = Color(0xFF8B0000),      // Deep Crimson
    onPrimary = Color(0xFFFFE0E0),
    primaryContainer = Color(0xFF520000),
    onPrimaryContainer = Color(0xFFFFDAD5),
    secondary = Color(0xFF1C1414),    // Blackstone
    onSecondary = Color(0xFFE0E0E0),
    secondaryContainer = Color(0xFF332929),
    onSecondaryContainer = Color(0xFFE0CDBA),
    tertiary = Color(0xFF5DADE2),     // Soul Fire Blue
    onTertiary = Color(0xFF000000),
    tertiaryContainer = Color(0xFF004A77),
    onTertiaryContainer = Color(0xFFC9E6FF),
    error = Color(0xFFFF6347),        // Lava Bright
    onError = Color(0xFF000000),
    errorContainer = Color(0xFFB33620),
    onErrorContainer = Color(0xFFFFDBCF),
    background = Color(0xFF0A0000),  // Pitch Black Red
    onBackground = Color(0xFFE6E0E0),
    surface = Color(0xFF1A0A0A),      // Dark Nether Brick
    onSurface = Color(0xFFD8C2BF),
    surfaceVariant = Color(0xFF534341),
    onSurfaceVariant = Color(0xFFD8C2BF),
    outline = Color(0xFFA08C8A)
)

// End Light Theme
val EndLightScheme = lightColorScheme(
    primary = Color(0xFFE3DDD1),      // End Stone Beige
    onPrimary = Color(0xFF443B2A),
    primaryContainer = Color(0xFFF8F2E7),
    onPrimaryContainer = Color(0xFF2C261C),
    secondary = Color(0xFF9B59B6),    // Chorus Purple
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFF2E3F8),
    onSecondaryContainer = Color(0xFF45274E),
    tertiary = Color(0xFF00CED1),     // Ender Pearl Cyan
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFAAF0F2),
    onTertiaryContainer = Color(0xFF00383A),
    error = Color(0xFF663399),        // Void Purple
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFE9DFFF),
    onErrorContainer = Color(0xFF21005D),
    background = Color(0xFFFFFACD),  // Pale Yellow
    onBackground = Color(0xFF2C261C),
    surface = Color(0xFF4A4A6A),      // Light Obsidian
    onSurface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFE7E0D3),
    onSurfaceVariant = Color(0xFF49463D),
    outline = Color(0xFF79766D)
)

// End Dark Theme
val EndDarkScheme = darkColorScheme(
    primary = Color(0xFF6A4C93),      // Dark Purpur
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF432E5D),
    onPrimaryContainer = Color(0xFFF8F2E7),
    secondary = Color(0xFF4B0082),    // Deep Purple
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFF320058),
    onSecondaryContainer = Color(0xFFF2E3F8),
    tertiary = Color(0xFF7FFF00),     // Ender Eye Green
    onTertiary = Color(0xFF000000),
    tertiaryContainer = Color(0xFF2A5900),
    onTertiaryContainer = Color(0xFFAAF0F2),
    error = Color(0xFFFF1493),        // Shulker Pink
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFF930052),
    onErrorContainer = Color(0xFFFFD9E6),
    background = Color(0xFF0A000A),  // Void Black
    onBackground = Color(0xFFEAEAEA),
    surface = Color(0xFF1A1A2E),      // Obsidian Dark
    onSurface = Color(0xFFC7C6D3),
    surfaceVariant = Color(0xFF49463D),
    onSurfaceVariant = Color(0xFFCAC5B9),
    outline = Color(0xFF939087)
)
