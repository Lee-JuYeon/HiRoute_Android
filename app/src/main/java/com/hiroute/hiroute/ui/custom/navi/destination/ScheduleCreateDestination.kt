package com.hiroute.hiroute.ui.custom.navi.destination

sealed class ScheduleCreateDestination(val route : String, val title : String) {
    object Create : ScheduleCreateDestination("Create", "작성")
    object Events : ScheduleCreateDestination("Events", "일정")
    object Place : ScheduleCreateDestination("Place", "장소")
    object PlaceDetail : ScheduleCreateDestination("PlaceDetail", "장소")

}