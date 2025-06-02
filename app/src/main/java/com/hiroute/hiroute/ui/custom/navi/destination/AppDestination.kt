package com.hiroute.hiroute.ui.custom.navi.destination

// 최상위 앱 네비게이션
sealed class AppDestination(val route : String, val title : String) {
    object Splash : AppDestination("Splash","splash")
    object Auth : AppDestination("Auth","login")
    object Main : AppDestination("Main","main")
    object FeedDetail : AppDestination("FeedDetail","main")
    object FeedCreate : AppDestination("FeedCreate","main")
    object ScheduleCreate : AppDestination("ScheduleCreate","main")
    object ScheduleGacha : AppDestination("ScheduleGacha","main")
}