package com.himo.OMCW

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.himo.OMCW.ui.navigation.NavGraph
import com.himo.OMCW.ui.theme.OfflineMinecraftWIKITheme
import com.himo.OMCW.ui.theme.ThemedBackground
import com.himo.OMCW.viewmodel.SettingsViewModel
import com.himo.OMCW.viewmodel.SettingsViewModelFactory
import com.himo.OMCW.data.datasource.LocalDataSource
import com.himo.OMCW.data.repository.ItemRepository


class MainActivity : ComponentActivity() {

    // Use the custom factory to instantiate the ViewModel
    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataSource = LocalDataSource(applicationContext)
        val repository = ItemRepository(dataSource)
        setContent {
            // Collect theme states from the ViewModel
            val themeStyle by settingsViewModel.themeStyle.collectAsState()
            val themeMode by settingsViewModel.themeMode.collectAsState()

            // Apply the root theme composable
            OfflineMinecraftWIKITheme(
                themeStyle = themeStyle,
                themeMode = themeMode
            ) {
                // Apply the themed background, which wraps all app content
                ThemedBackground(themeStyle = themeStyle) {
                    val navController = rememberNavController()
                    // Your NavGraph goes here, make sure to pass the viewmodel if needed
                    NavGraph(navController = navController, repository = repository, settingsViewModel = settingsViewModel)
                }
            }
        }
    }
}