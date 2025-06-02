package com.hiroute.hiroute.ui.screen.feed.create

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.util.Date

data class FeedModel(
    val uid : String,
    val title : String,
    val eventList : List<FeedEventModel>
){}

data class FeedEventModel(
    val uid : String,
    val tiem : Date,
    val location : String,
    val description : String,
    var photoUrlList : List<String>
){

}

@Composable
fun FeedCreateBaseView(){

    val hint = "제목"
    val title = remember { mutableStateOf("") }
    val mList = remember { mutableStateOf(FeedModel(uid = "",title = "", eventList = listOf())) }

    LazyColumn (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Text(
                "글쓰기",
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        item {
            Button(
                onClick = { /* 포인트 정보 */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "업로드시 N원지급!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        item {
            OutlinedTextField(
                value = title.value,
                onValueChange = { newValue ->
                    title.value = newValue
                    // mList의 title도 업데이트
                    mList.value = mList.value.copy(title = newValue)
                },
                placeholder = { Text(hint) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = { Text(hint) }
            )
        }

        if (mList.value.eventList.size == 0){
            item {
                EmptyEventListView {

                }
            }
        }else{
            items(mList.value.eventList){ item: FeedEventModel ->
                FeedEventCell(model = item)
            }
        }


        item {
            Button(
                onClick = { /* 포인트 정보 */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "올리기",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun FeedEventCell(model : FeedEventModel){
    Row (
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text("시간 위치")
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){
            Text("본문 내용")

            LazyRow {
                items(model.photoUrlList){ photoURL ->
                    Text("사진 URL")
                }
            }
        }
    }
}

@Composable
fun EmptyEventListView(
    onAddSchedule: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp) // 고정 높이 또는 적절한 최소 높이
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .clickable { onAddSchedule() },
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "일정추가하기",
                modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 16.dp),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}