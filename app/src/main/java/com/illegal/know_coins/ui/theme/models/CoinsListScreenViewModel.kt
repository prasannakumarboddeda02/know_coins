package com.illegal.know_coins.ui.theme.models

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.illegal.know_coins.data.retrofit.CoinsDtoItem
import com.illegal.know_coins.repositories.CoinsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class CoinsListScreenViewModel : ViewModel() {

    private val coinsRepository = CoinsRepository()

    private val _data = MutableLiveData<List<CoinsDtoItem>>()
    val data: LiveData<List<CoinsDtoItem>> get() = _data


    fun getCoins(){
        viewModelScope.launch {
            try{
                _data.value = coinsRepository.getCoinsApi()
            }
            catch (e : Exception){
                Log.d("pk:","exception occurred")
            }
        }
    }


}