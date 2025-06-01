package com.hiroute.hiroute.ui.screen.main.feed.feedlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hiroute.hiroute.ui.screen.main.feed.FeedModel

fun LazyListScope.FeedList(list: List<FeedModel>) {
    items(list.chunked(2)) { rowItems ->
        FeedItem(rowItems = rowItems)
    }
}