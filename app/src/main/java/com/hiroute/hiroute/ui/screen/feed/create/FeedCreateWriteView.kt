package com.hiroute.hiroute.ui.screen.feed.create

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hiroute.hiroute.model.FeedEventModel

@Composable
fun FeedCreateWriteView(
    onNavigateToFeedBase: () -> Unit,
    feedEventModel: MutableState<FeedEventModel>,
    uploadEventModel : (FeedEventModel) -> Unit
){

    val mModel = remember { feedEventModel }
    val hint = "글 내용"

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text("시간(새벽,오전,오후)",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Left
        )
        Text("위치",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Left
        )

        OutlinedTextField(
            value = mModel.value.description,
            onValueChange = { newValue ->
                val updatedModel = mModel.value.copy(description = newValue)
                mModel.value = updatedModel
            },
            placeholder = { Text(hint) },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // 남은 공간을 모두 차지
            singleLine = false,
            label = { Text(hint) }
        )


        LazyRow (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ){
            item {
                Card(
                    modifier = Modifier
                        .size(80.dp) // 정사각형 크기
                        .clickable { /* 사진 추가 로직 */ },
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    border = BorderStroke(2.dp, Color.Black),
                    shape = RectangleShape
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "사진\n추가하기",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            lineHeight = 14.sp
                        )
                    }
                }
            }

            items(mModel.value.photoUrlList){ photoURL : String ->
                Text(photoURL)
            }
        }

        Button(
            onClick = {
                uploadEventModel(mModel.value)
                onNavigateToFeedBase()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "추가하기",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }
}