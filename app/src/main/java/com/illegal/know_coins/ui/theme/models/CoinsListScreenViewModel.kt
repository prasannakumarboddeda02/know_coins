package com.illegal.know_coins.ui.theme.models

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.illegal.know_coins.data.retrofit.CoinsDtoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CoinsListScreenViewModel : ViewModel() {

    private lateinit var coinsData : List<CoinsDtoItem>

    init{
        coinsData
    }


}