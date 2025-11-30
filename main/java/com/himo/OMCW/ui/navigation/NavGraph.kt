package com.himo.OMCW.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.himo.OMCW.data.repository.ItemRepository
import com.himo.OMCW.ui.screens.HomeScreen
import com.himo.OMCW.ui.screens.ItemDetailScreen
import com.himo.OMCW.ui.screens.SettingsScreen
import com.himo.OMCW.viewmodel.HomeViewModel
import com.himo.OMCW.viewmodel.SettingsViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Settings : Screen("settings")
    object ItemDetail : Screen("item/{itemId}") {
        fun createRoute(itemId: String) = "item/$itemId"
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun NavGraph(
    navController: NavHostController,
    repository: ItemRepository,
    settingsViewModel: SettingsViewModel
){
    val homeViewModel = HomeViewModel(repository)

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route) {
            HomeScreen(
                viewModel = homeViewModel,
                onItemClick = { itemId ->
                    navController.navigate(Screen.ItemDetail.createRoute(itemId))
                },
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }

        composable(Screen.Settings.route) {
            SettingsScreen(
                viewModel = settingsViewModel
            )
        }

        composable(
            route = Screen.ItemDetail.route,
            arguments = listOf(
                navArgument("itemId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            val item = itemId?.let { repository.getItemById(it) }
            val recipes = itemId?.let { repository.getRecipesForItem(it) } ?: emptyList()

            ItemDetailScreen(
                item = item,
                recipes = recipes,
                onBackClick = { navController.navigateUp() },
                onRelatedItemClick = { relatedId ->
                    navController.navigate(Screen.ItemDetail.createRoute(relatedId))
                }
            )
        }
    }
}