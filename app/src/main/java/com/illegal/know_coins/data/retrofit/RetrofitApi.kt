package com.illegal.know_coins.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinsDtoItem>

    @GET("/v1/coins/{id}")
    suspend fun getCoinById(@Path("id") id : String) : CoinIndividualDto

}