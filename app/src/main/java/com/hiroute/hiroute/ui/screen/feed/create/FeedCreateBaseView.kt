package com.hiroute.hiroute.ui.screen.feed.create

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hiroute.hiroute.model.FeedEventModel
import com.hiroute.hiroute.model.FeedModel


@Composable
fun FeedCreateBaseView(
    onNavigateToFeedWrite: () -> Unit,
    feedModel : MutableState<FeedModel>,
    onAddEvent : () -> Unit
){

    val hint = "제목"
    val title = remember { mutableStateOf(feedModel.value.title) }

    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(16.dp), // 모든 아이템 간 간격
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
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }

        item {
            OutlinedTextField(
                value = title.value,
                onValueChange = { newValue ->
                    title.value = newValue
                    // mList의 title도 업데이트
                    feedModel.value = feedModel.value.copy(title = newValue)
                },
                placeholder = { Text(hint) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                label = { Text(hint) }
            )
        }

//        if (feedModel.value.eventList.isEmpty()) {
//            item {
//                EmptyEventListView {
//                    onNavigateToFeedWrite()
//                }
//            }
//        }else{

        item {
            Text("헤더 : 이벤트 추가하기",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RectangleShape // 정사각형 모양
                    )
                    .clickable {
                        onNavigateToFeedWrite()
                    })
        }

        items(feedModel.value.eventList) { item: FeedEventModel ->
            FeedEventCell(model = item)
        }

//        }


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
