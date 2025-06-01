package com.hiroute.hiroute.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "홈", Icons.Default.Home)
    object Feed : Screen("feed", "일정피드", Icons.Default.Menu)
    object Schedule : Screen("manage", "일정관리", Icons.Default.Edit)
    object MyPage : Screen("mypage", "마이페이지", Icons.Default.Person)
}