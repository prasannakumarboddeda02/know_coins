package com.illegal.know_coins.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.illegal.know_coins.data.retrofit.models.Tag

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Tags(tags :List<Tag>){
    FlowRow(
        //horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth(),
    ){
        for(i in tags){
            Box(
                modifier = Modifier
                    .padding(bottom = 8.dp, end = 8.dp)
                    .border(width = 2.dp, color = Color.Green, shape = RoundedCornerShape(100.dp))
                    .padding(all = 10.dp)
            ) {
                Text(
                    text = i.name,
                    color = Color.White
                )
            }
        }
    }
}