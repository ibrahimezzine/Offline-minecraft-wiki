package com.himo.OMCW
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.himo.OMCW.data.datasource.LocalDataSource
import com.himo.OMCW.data.repository.ItemRepository
import com.himo.OMCW.ui.navigation.NavGraph
import com.himo.OMCW.ui.theme.OfflineMinecraftWIKITheme
import com.himo.OMCW.viewmodel.SettingsViewModel
class MainActivity : ComponentActivity() {
    override
    fun onCreate(
        savedInstanceState
        : Bundle?
    ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dataSource = LocalDataSource(applicationContext)
        val repository = ItemRepository(dataSource)
        val settingsViewModel = SettingsViewModel(applicationContext)
        setContent {
            val isDarkTheme by settingsViewModel.isDarkTheme.collectAsState()
            OfflineMinecraftWIKITheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    repository = repository,
                    settingsViewModel = settingsViewModel
                )
            }
        }
    }
}