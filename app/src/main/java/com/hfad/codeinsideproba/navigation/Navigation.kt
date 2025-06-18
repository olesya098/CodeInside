package com.hfad.codeinsideproba.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hfad.codeinsideproba.OfficeMapScreen.OfficeMapScreen
import com.hfad.codeinsideproba.OfficeMapScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModelOffice = viewModel<OfficeMapScreenViewModel>()
    NavHost(
        navController = navController,
        startDestination = OfficeMapScreenRoute
    ) {
        composable<OfficeMapScreenRoute> {
            OfficeMapScreen(
                viewModelOffice
            )
        }
    }
}