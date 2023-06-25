package com.illegal.know_coins.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.illegal.know_coins.ui.components.CoinDescription
import com.illegal.know_coins.ui.components.CoinTitle
import com.illegal.know_coins.ui.components.Tags
import com.illegal.know_coins.ui.components.TeamMemberList
import com.illegal.know_coins.ui.viewmodels.CoinIndividualScreenViewModel


@Composable
fun CoinIndividualScreen(
    coinName :String
) {
    val viewModel: CoinIndividualScreenViewModel = viewModel()
    viewModel.getCoinDetails(id = coinName)
    //val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF424549))
    ) {
        var alignment: Alignment = Alignment.Center
        if (viewModel.coin != null) {
            alignment = Alignment.TopStart
        }
        Box(
            contentAlignment = alignment,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF424549))
                .padding(all = 18.dp)
            //.verticalScroll(state = scrollState)
        ) {
            LazyColumn {
                item {
                    if (viewModel.coin == null) {
                        CircularProgressIndicator()
                    } else {
                        Column(
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            CoinTitle(
                                rank = viewModel.coin!!.rank,
                                name = viewModel.coin!!.name,
                                active = viewModel.coin!!.is_active
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            CoinDescription(
                                description = viewModel.coin!!.description
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Tags:",
                                style = TextStyle(
                                    color = Color(0xFFE0AC69),
                                    fontSize = 25.sp
                                ),
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Tags(tags = viewModel.coin!!.tags)
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Team members:",
                                style = TextStyle(
                                    color = Color(0xFFE0AC69),
                                    fontSize = 25.sp
                                ),
                            )

                        }
                    }
                }
                viewModel.coin?.let { it ->
                    items(it.team) {
                        TeamMemberList(teamMember = it)
                    }
                }
            }
        }
    }
}

