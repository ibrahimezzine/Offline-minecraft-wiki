package com.himo.OMCW.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Enums to represent the different theme options
enum class ThemeStyle {
    DEFAULT,
    OVERWORLD,
    NETHER,
    END
}

enum class ThemeMode {
    LIGHT,
    DARK
}

class SettingsViewModel(context: Context) : ViewModel() {

    private val prefs = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)

    // StateFlow for Theme Style (e.g., Overworld, Nether)
    private val _themeStyle = MutableStateFlow(
        ThemeStyle.valueOf(prefs.getString("theme_style", ThemeStyle.DEFAULT.name) ?: ThemeStyle.DEFAULT.name)
    )
    val themeStyle: StateFlow<ThemeStyle> = _themeStyle.asStateFlow()

    // StateFlow for Theme Mode (Light/Dark)
    private val _themeMode = MutableStateFlow(
        ThemeMode.valueOf(prefs.getString("theme_mode", ThemeMode.LIGHT.name) ?: ThemeMode.LIGHT.name)
    )
    val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

    /**
     * Updates the current theme style and saves it to SharedPreferences.
     */
    fun setThemeStyle(style: ThemeStyle) {
        _themeStyle.value = style
        prefs.edit().putString("theme_style", style.name).apply()
    }

    /**
     * Updates the current theme mode (light/dark) and saves it to SharedPreferences.
     */
    fun setThemeMode(mode: ThemeMode) {
        _themeMode.value = mode
        prefs.edit().putString("theme_mode", mode.name).apply()
    }
}

/**
 * Factory for creating a SettingsViewModel with a Context dependency.
 */
class SettingsViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
