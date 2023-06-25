package com.illegal.know_coins.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.illegal.know_coins.data.retrofit.CoinsDtoItem
import com.illegal.know_coins.repositories.CoinsRepository
import kotlinx.coroutines.launch

class CoinsListScreenViewModel : ViewModel() {

    private val coinsRepository = CoinsRepository()

    var data : List<CoinsDtoItem> by mutableStateOf(emptyList())

    fun getCoins(){
        viewModelScope.launch {
            try{
                data = coinsRepository.getCoinsApi()
            }
            catch (e : Exception){
                Log.d("pk:","exception occurred")
            }
        }
    }


}