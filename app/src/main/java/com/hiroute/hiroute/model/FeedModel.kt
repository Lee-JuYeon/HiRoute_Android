package com.hiroute.hiroute.model



data class FeedModel(
    val uid : String,
    val title : String,
    val eventList : List<FeedEventModel>,
    val likes: Int,
    val isBookmarked: Boolean = false
){}