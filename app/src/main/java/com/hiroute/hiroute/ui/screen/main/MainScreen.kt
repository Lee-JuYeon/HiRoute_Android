package com.hiroute.hiroute.ui.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hiroute.hiroute.ui.custom.bottomnavi.BottomNavigationBar
import com.hiroute.hiroute.ui.custom.bottomnavi.BottomNavigationBarModel
import com.hiroute.hiroute.ui.screen.Screen
import com.hiroute.hiroute.ui.screen.main.feed.FeedView
import com.hiroute.hiroute.ui.screen.main.home.HomeView
import com.hiroute.hiroute.ui.screen.main.mypage.MyPageView
import com.hiroute.hiroute.ui.screen.main.schedule.ScheduleView

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationBarModel.Home,
        BottomNavigationBarModel.Feed,
        BottomNavigationBarModel.Schedule,
        BottomNavigationBarModel.MyPage
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, items = items)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route
            ) {
                composable(Screen.Home.route) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        HomeView()
                    }
                }
                composable(Screen.Feed.route) { FeedView() }
                composable(Screen.Schedule.route) { ScheduleView() }
                composable(Screen.MyPage.route) { MyPageView() }
            }
        }
    }
}