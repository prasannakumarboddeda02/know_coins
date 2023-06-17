package com.illegal.know_coins.repositories

import com.illegal.know_coins.MainActivity
import com.illegal.know_coins.data.retrofit.CoinsDtoItem

class CoinsRepository {

    val retrofit = MainActivity.getRetrofitInstance()

suspend fun getCoinsApi() : List<CoinsDtoItem>{
    return retrofit.getCoins()
}


}