package com.hiroute.hiroute.ui.screen.feed.create

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hiroute.hiroute.model.FeedEventModel
import com.hiroute.hiroute.model.FeedModel
import kotlinx.coroutines.launch
import java.util.Date

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeedCreateScreen(
    navController : NavHostController
) {

    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()

    // 기본 FeedEventModel 생성
    val defaultEventModel = FeedEventModel(
        uid = "",
        tiem = Date(),
        location = "",
        description = "",
        photoUrlList = listOf()
    )

    val mFeedModel = remember {
        mutableStateOf(
            FeedModel(
                uid = "",
                title = "",
                eventList = listOf(defaultEventModel), // 기본 이벤트 하나 포함
                likes = 0,
                isBookmarked = false
            )
        )
    }

    // 현재 편집 중인 이벤트의 인덱스
    val currentEventIndex = remember { mutableStateOf(0) }


    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        userScrollEnabled = false // 스크롤 불가능
    ) { page ->
        when (page) {
            0 -> FeedCreateBaseView(
                onNavigateToFeedWrite = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(1) // 페이지 1로 이동 (0-based index)
                    }
                },
                feedModel = mFeedModel,
                onAddEvent = {
                    // 새 이벤트 추가
                    val newEvent = FeedEventModel(
                        uid = "",
                        tiem = Date(),
                        location = "",
                        description = "",
                        photoUrlList = listOf()
                    )
                    val updatedEventList = mFeedModel.value.eventList + newEvent
                    mFeedModel.value = mFeedModel.value.copy(eventList = updatedEventList)
                    currentEventIndex.value = updatedEventList.size - 1 // 새 이벤트로 인덱스 설정
                }
            )
            1 -> FeedCreateWriteView(
                onNavigateToFeedBase = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(0) // 페이지 1로 이동 (0-based index)
                    }
                },
                feedEventModel = remember {
                    mutableStateOf(mFeedModel.value.eventList[currentEventIndex.value])
                },
                uploadEventModel = { updatedEvent ->
                    // 이벤트 업데이트
                    val updatedList = mFeedModel.value.eventList.toMutableList()
                    updatedList[currentEventIndex.value] = updatedEvent
                    mFeedModel.value = mFeedModel.value.copy(eventList = updatedList)
                }
            )
        }
    }
}



