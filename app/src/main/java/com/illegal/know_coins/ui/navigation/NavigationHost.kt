package com.illegal.know_coins.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.illegal.know_coins.ui.screens.CoinIndividualScreen
import com.illegal.know_coins.ui.screens.CoinsListScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = "CoinsListScreen"
    ){
        composable("CoinsListScreen") {
            CoinsListScreen(
                navController = navController,
            )
        }
        composable(
            "CoinIndividualScreen/{coinName}",
            arguments = listOf(navArgument("coinName") { type = NavType.StringType })
        ){
            it.arguments?.getString("coinName")?.let { it1 ->
                CoinIndividualScreen(
                    it1
                )
            }
        }
    }
}