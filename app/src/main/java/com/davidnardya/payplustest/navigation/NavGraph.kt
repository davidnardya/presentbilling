package com.davidnardya.payplustest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.davidnardya.payplustest.navigation.screens.BillingDetailsScreen
import com.davidnardya.payplustest.navigation.screens.HomeScreen
import com.davidnardya.payplustest.viewmodels.MainViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController, viewModel: MainViewModel
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(viewModel, navController)
        }
        composable(
            route = Screen.BillingEntry.route
        ) {
            BillingDetailsScreen(viewModel, navController)
        }
    }
}