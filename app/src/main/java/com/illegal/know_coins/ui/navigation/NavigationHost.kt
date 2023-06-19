package com.illegal.know_coins.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.illegal.know_coins.ui.screens.CoinIndividualScreen
import com.illegal.know_coins.ui.screens.CoinsListScreen
import com.illegal.know_coins.ui.viewmodels.CoinsListScreenViewModel

@Composable
fun NavigationHost(
    navController: NavHostController,
    coinsListScreenViewModel: CoinsListScreenViewModel
){
    NavHost(
        navController = navController,
        startDestination = "CoinsListScreen"
    ){
        composable("CoinsListScreen") {
            CoinsListScreen(
                navController = navController,
                coinsListScreenViewModel = coinsListScreenViewModel
            )
        }
        composable("CoinIndividualScreen"){
            CoinIndividualScreen()
        }
    }
}