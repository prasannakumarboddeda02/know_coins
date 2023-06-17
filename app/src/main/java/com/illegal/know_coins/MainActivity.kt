package com.illegal.know_coins

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.illegal.know_coins.data.retrofit.RetrofitApi
import com.illegal.know_coins.ui.theme.Know_coinsTheme
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Know_coinsTheme {
                // A surface container using the 'background' color from the theme
                    val retrofit = getRetrofitInstance()
                    runBlocking {
                        Log.d("pk:",retrofit.getCoins().toString())
                    }
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
