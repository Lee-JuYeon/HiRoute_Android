package com.hiroute.hiroute.ui.screen.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hiroute.hiroute.ui.custom.bottomnavi.BottomNavigationBar
import com.hiroute.hiroute.ui.custom.bottomnavi.BottomNavigationBarModel
import com.hiroute.hiroute.ui.custom.navi.destination.MainTabDestination
import com.hiroute.hiroute.ui.screen.main.feed.FeedModel
import com.hiroute.hiroute.ui.screen.main.feed.FeedView
import com.hiroute.hiroute.ui.screen.main.home.HomeView
import com.hiroute.hiroute.ui.screen.main.mypage.MyPageView
import com.hiroute.hiroute.ui.screen.main.schedule.ScheduleView

@Composable
fun MainScreen(
    onNavigateToFeedCreate: () -> Unit,
    onNavigateToFeedDetail: () -> Unit
) {

    // MainScreen 내부에서 자체적으로 NavController 생성
    val bottomNavController = rememberNavController()

    val items = listOf(
        BottomNavigationBarModel.Home,
        BottomNavigationBarModel.Feed,
        BottomNavigationBarModel.Schedule,
        BottomNavigationBarModel.MyPage
    )

    // 샘플 피드 데이터
    val feedModels = listOf(
        FeedModel(1, "서울 야경 투어 코스", "🌃", 24, 8),
        FeedModel(2, "부산 해변 드라이브", "🏖️", 18, 5, true),
        FeedModel(3, "제주도 맛집 탐방", "🍜", 32, 12),
        FeedModel(4, "경주 역사 여행", "🏛️", 15, 3),
        FeedModel(5, "강릉 카페 투어", "☕", 28, 9, true),
        FeedModel(6, "인천 차이나타운", "🥟", 21, 6)
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = bottomNavController, items = items)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(
                navController = bottomNavController,
                startDestination = MainTabDestination.Home.route
            ) {
                composable(MainTabDestination.Home.route) {
                    HomeView()
                }
                composable(MainTabDestination.Feed.route) {
                    FeedView(
                        list = feedModels,
                        onCreateFeed = {
                            onNavigateToFeedCreate()
                        }
                    )
                }
                composable(MainTabDestination.Schedule.route) { ScheduleView() }
                composable(MainTabDestination.MyPage.route) { MyPageView() }
            }
        }
    }
}

