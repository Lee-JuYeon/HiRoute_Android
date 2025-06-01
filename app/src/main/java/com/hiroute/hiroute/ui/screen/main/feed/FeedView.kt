package com.hiroute.hiroute.ui.screen.main.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hiroute.hiroute.ui.screen.main.feed.feedheader.FeedHeaderView
import com.hiroute.hiroute.ui.screen.main.feed.feedlist.FeedList

// 피드 아이템 데이터 클래스


@Composable
fun FeedView(list : List<FeedModel>) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 상단 헤더 (고정)
        FeedHeaderView()

        FeedList(list)
    }
}

