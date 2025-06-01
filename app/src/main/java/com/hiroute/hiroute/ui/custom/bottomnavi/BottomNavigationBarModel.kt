package com.hiroute.hiroute.ui.custom.bottomnavi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationBarModel(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavigationBarModel("home", "홈", Icons.Default.Home)
    object Feed : BottomNavigationBarModel("feed", "일정피드", Icons.Default.Menu)
    object Schedule : BottomNavigationBarModel("schedule", "일정관리", Icons.Default.Edit)
    object MyPage : BottomNavigationBarModel("mypage", "마이페이지", Icons.Default.Person)
}