package com.himo.OMCW.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himo.OMCW.ui.theme.*
import com.himo.OMCW.viewmodel.SettingsViewModel
import com.himo.OMCW.viewmodel.ThemeMode
import com.himo.OMCW.viewmodel.ThemeStyle

@Composable
fun SettingsScreen(viewModel: SettingsViewModel) {
    val currentThemeStyle by viewModel.themeStyle.collectAsState()
    val currentThemeMode by viewModel.themeMode.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            "Settings",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Appearance Section
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Appearance",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Theme Style Selector
                ThemeStyleSelector(
                    currentStyle = currentThemeStyle,
                    onStyleSelected = { viewModel.setThemeStyle(it) }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Theme Mode Selector
                ThemeModeSelector(
                    currentMode = currentThemeMode,
                    onModeSelected = { viewModel.setThemeMode(it) }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // About Section
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "About",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text("Offline Minecraft Wiki", style = MaterialTheme.typography.bodyLarge)
                Text("Version 1.0", style = MaterialTheme.typography.bodyMedium)
                Text("Developed by Ibrahim", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.tertiary)
            }
        }
    }
}

@Composable
fun ThemeStyleSelector(currentStyle: ThemeStyle, onStyleSelected: (ThemeStyle) -> Unit) {
    Column {
        Text("Theme Style", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        ThemeStyle.values().forEach { style ->
            val colors = when(style) {
                ThemeStyle.DEFAULT -> DefaultLightScheme
                ThemeStyle.OVERWORLD -> OverworldLightScheme
                ThemeStyle.NETHER -> NetherLightScheme
                ThemeStyle.END -> EndLightScheme
            }
            RadioRow(
                text = style.name.toLowerCase().capitalize(),
                selected = currentStyle == style,
                onClick = { onStyleSelected(style) },
                colorSwatch = colors.primary
            )
        }
    }
}

@Composable
fun ThemeModeSelector(currentMode: ThemeMode, onModeSelected: (ThemeMode) -> Unit) {
    Column {
        Text("Theme Mode", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        ThemeMode.values().forEach { mode ->
            RadioRow(
                text = if (mode == ThemeMode.LIGHT) "Light Mode" else "Dark Mode",
                selected = currentMode == mode,
                onClick = { onModeSelected(mode) }
            )
        }
    }
}

@Composable
private fun RadioRow(text: String, selected: Boolean, onClick: () -> Unit, colorSwatch: Color? = null) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(48.dp)
            .selectable(
                selected = selected,
                onClick = onClick,
                role = Role.RadioButton
            )
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (colorSwatch != null) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(colorSwatch)
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
        Text(text, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
        RadioButton(
            selected = selected,
            onClick = null // null recommended for accessibility with selectable parent
        )
    }
}
