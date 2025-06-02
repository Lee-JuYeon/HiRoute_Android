package com.hiroute.hiroute.ui.custom.navi.destination

// 일정피드 - '글추가'
sealed class FeedCreateDestination(val route : String, val title : String) {
    object Step1 : FeedCreateDestination("Detail", "자세히보기")
}
