package com.hiroute.hiroute.ui.custom.navi.destination

sealed class ScheduleGachaDestination(val route : String, val title : String) {
    object Step1 : ScheduleGachaDestination("Step1", "") // 일정추가하기
    object Step2 : ScheduleGachaDestination("Step2", "") // 세부사항 입력
    object Step3 : ScheduleGachaDestination("Step3", "") // 최종 확인

}
