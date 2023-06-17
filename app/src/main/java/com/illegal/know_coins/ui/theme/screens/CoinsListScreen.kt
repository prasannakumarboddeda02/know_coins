package com.illegal.know_coins.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.illegal.know_coins.data.retrofit.CoinsDtoItem

@Composable
fun CoinsListScreen(
    coins: List<CoinsDtoItem>,
    isLoading : Boolean
){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            }
        }
            LazyColumn {
                items(coins.size) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 20.dp)
                    ) {
                        Text(
                            text = "${coins[it].rank}. ${coins[it].name} ${coins[it].id}"
                        )
                    }
                }
            }
        }
}
