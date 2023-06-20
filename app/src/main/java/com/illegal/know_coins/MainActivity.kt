package com.illegal.know_coins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.illegal.know_coins.data.retrofit.RetrofitApi
import com.illegal.know_coins.ui.navigation.NavigationHost
import com.illegal.know_coins.ui.theme.Know_coinsTheme
import com.illegal.know_coins.ui.viewmodels.CoinsListScreenViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {


    private val coinsListScreenViewModel : CoinsListScreenViewModel by viewModels()
    private lateinit var navController: NavHostController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Know_coinsTheme {
                navController = rememberNavController()
                NavigationHost(
                    navController = navController,
                    coinsListScreenViewModel = coinsListScreenViewModel
                )
            }
        }
    }


    companion object{

        private const val baseUrl: String = "https://api.coinpaprika.com"

        fun getRetrofitInstance(): RetrofitApi{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitApi::class.java)
        }

    }
}
