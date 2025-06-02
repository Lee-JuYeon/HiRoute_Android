package com.hiroute.hiroute.ui.screen.feed.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import com.hiroute.hiroute.model.FeedEventModel


@Composable
fun FeedEventCell(model : FeedEventModel){
    Row (
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RectangleShape // 정사각형 모양
            )
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RectangleShape // 정사각형 모양
            )
    ){
        Text("시간 위치")
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){
            Text(
                "본문 내용"
            )

            LazyRow {
                items(model.photoUrlList){ photoURL ->
                    Text("사진 URL")
                }
            }
        }
    }
}
