package com.illegal.know_coins

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.illegal.know_coins.data.retrofit.CoinsDtoItem
import com.illegal.know_coins.data.retrofit.RetrofitApi
import com.illegal.know_coins.ui.theme.Know_coinsTheme
import com.illegal.know_coins.ui.theme.models.CoinsListScreenViewModel
import com.illegal.know_coins.ui.theme.screens.CoinsListScreen
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {


    private val coinsListScreenViewModel : CoinsListScreenViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Know_coinsTheme {
                var coins : List<CoinsDtoItem> by remember{
                    mutableStateOf(emptyList())
                }
                coinsListScreenViewModel.data.observe(this, Observer{
                    coins = it
                })
                // A surface container using the 'background' color from the theme
                    coinsListScreenViewModel.getCoins()
                    CoinsListScreen(
                        coins = coins,
                        isLoading = coins.isEmpty()
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Know_coinsTheme {

    }
}
