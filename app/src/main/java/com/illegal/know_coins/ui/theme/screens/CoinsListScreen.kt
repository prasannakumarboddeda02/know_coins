package com.illegal.know_coins.ui.theme.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.illegal.know_coins.data.retrofit.CoinsDtoItem

@Composable
fun CoinsListScreen(
    coins: List<CoinsDtoItem>,
    isLoading : Boolean
){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF424549)),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(color = Color(0xFF424549))
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            }
        }
            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 10.dp)
                    ){
                items(coins.size) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        var loc = 0
                        for(i in 0 until coins[it].id.length){
                            if(coins[it].id[i]=='-'){
                                loc = i
                                break
                            }
                    }
                        Text(
                            text = "${coins[it].rank}. ${coins[it].name}",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 18.sp
                            )
                        )
                        Text(
                            text = coins[it].id.substring(0,loc),
                            color = Color.Green,
                            textAlign = TextAlign.End,
                            modifier = Modifier,
                            fontStyle = FontStyle.Italic
                        )
                    }
                    Divider(color = Color(0xFF282b30), thickness = 1.dp)
                }
            }
    }
}
