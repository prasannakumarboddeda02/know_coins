package com.illegal.know_coins.repositories

import com.illegal.know_coins.MainActivity
import com.illegal.know_coins.data.retrofit.CoinIndividualDto

class CoinIndividualRepository {

    val retrofit = MainActivity.getRetrofitInstance()

    suspend fun getCoinDetails( id : String) :CoinIndividualDto{
        return retrofit.getCoinById(id = id)
    }
}