package com.hiroute.hiroute.ui.screen.main.feed

data class FeedModel(
    val id: Int,
    val title: String,
    val image: String = "🏙️",
    val likes: Int,
    val comments: Int,
    val isBookmarked: Boolean = false
)