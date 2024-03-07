package com.davidnardya.payplustest.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("HomeScreen")
    data object BillingEntry : Screen("BillingEntryScreen")
}
