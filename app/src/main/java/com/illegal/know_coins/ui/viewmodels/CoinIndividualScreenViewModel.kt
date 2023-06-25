package com.illegal.know_coins.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.illegal.know_coins.data.retrofit.CoinIndividualDto

import com.illegal.know_coins.repositories.CoinIndividualRepository
import kotlinx.coroutines.launch

class CoinIndividualScreenViewModel : ViewModel() {

    private val coinIndividualRepository = CoinIndividualRepository()

    var coin : CoinIndividualDto? by mutableStateOf(null)

    fun getCoinDetails(id : String){
        viewModelScope.launch {
            coin = coinIndividualRepository.getCoinDetails(id = id)
        }
    }
}