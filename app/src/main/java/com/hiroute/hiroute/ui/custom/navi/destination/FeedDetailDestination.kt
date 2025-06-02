package com.hiroute.hiroute.ui.custom.navi.destination


// 일정피드 - 아이템 클릭
sealed class FeedDetailDestination(val route : String, val title : String) {
    object Detail : FeedDetailDestination("Detail", "자세히보기")
}


