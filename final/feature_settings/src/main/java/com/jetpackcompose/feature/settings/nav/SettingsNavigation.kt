package com.jetpackcompose.feature.settings.nav

import androidx.compose.material3.DrawerState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jetpackcompose.feature.settings.SettingsScreen
import com.jetpackcompose.feature.settings.SettingsViewModel
import com.jetpackcompose.feature.settings.details.SettingsDetailsScreen

const val settingsRoute = "settings"

const val settingsDetailsRoute = "settings_details"

fun NavGraphBuilder.settingsScreen(drawerState: DrawerState,navController: NavController) {
    composable(settingsRoute) {
        val viewModel: SettingsViewModel = hiltViewModel()
        SettingsScreen(
            drawerState = drawerState,
            viewModel = viewModel,
            onNavigate = {
                navController.navigate(settingsDetailsRoute)
            }
        )
    }

    composable(settingsDetailsRoute) {
        SettingsDetailsScreen(
            onNavigate = {
                navController.popBackStack()
            }
        )
    }
}