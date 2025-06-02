package com.hiroute.hiroute.ui.custom.navi.destination

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector



// 메인 화면 탭들 (Bottom Navigation)
sealed class MainTabDestination(val route: String, val title: String, val icon: ImageVector) {
    object Home : MainTabDestination("Home", "홈", Icons.Default.Home)
    object Feed : MainTabDestination("Feed", "일정피드", Icons.Default.Menu)
    object Schedule : MainTabDestination("Schedule", "일정관리", Icons.Default.Edit)
    object MyPage : MainTabDestination("MyPage", "마이페이지", Icons.Default.Person)
}





