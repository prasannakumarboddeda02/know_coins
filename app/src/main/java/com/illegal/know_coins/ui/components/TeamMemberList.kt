package com.illegal.know_coins.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.illegal.know_coins.data.retrofit.models.Team

@Composable
fun TeamMemberList(
    teamMember : Team
){
    Column(
        modifier = Modifier
    ) {
        Text(
            text = teamMember.name,
            modifier = Modifier.padding(all = 5.dp),
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
        )
        Text(
            text = teamMember.position,
            modifier = Modifier.padding(all = 5.dp),
            fontStyle = FontStyle.Italic,
            style = TextStyle(
                color = Color.Yellow,
                fontSize = 15.sp
            ),
        )
        Divider(color = Color(0xFF282b30), thickness = 1.dp)
    }
}
