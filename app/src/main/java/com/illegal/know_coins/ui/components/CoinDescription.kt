package com.illegal.know_coins.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun CoinDescription(description :String){
    Text(
        text = description.ifEmpty { "No Description" },
        style = TextStyle(
            color = Color.White,
            fontSize = 18.sp
        )
    )
}