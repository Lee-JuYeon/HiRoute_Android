package com.hiroute.hiroute.ui.custom.navi

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.hiroute.hiroute.ui.custom.navi.destination.AppDestination
import com.hiroute.hiroute.ui.custom.navi.destination.AuthDestination
import com.hiroute.hiroute.ui.custom.navi.destination.FeedCreateDestination
import com.hiroute.hiroute.ui.custom.navi.destination.FeedDetailDestination
import com.hiroute.hiroute.ui.custom.navi.destination.ScheduleCreateDestination
import com.hiroute.hiroute.ui.custom.navi.destination.ScheduleGachaDestination
import com.hiroute.hiroute.ui.screen.auth.login.LoginScreen
import com.hiroute.hiroute.ui.screen.auth.register.RegisterScreen
import com.hiroute.hiroute.ui.screen.feed.create.FeedCreateScreen
import com.hiroute.hiroute.ui.screen.feed.detail.FeedDetailScreen
import com.hiroute.hiroute.ui.screen.main.MainScreen
import com.hiroute.hiroute.ui.screen.schedule.create.ScheduleCreateScreen
import com.hiroute.hiroute.ui.screen.schedule.gacha.ScheduleGachaScreen
import com.hiroute.hiroute.ui.screen.splash.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestination.Main.route
    ) {
        // 스플래시 화면
        composable(AppDestination.Splash.route) {
            SplashScreen(
//                onNavigateToAuth = {
//                    navController.navigate(AppDestination.Auth.route) {
//                        popUpTo(AppDestination.Splash.route) { inclusive = true }
//                    }
//                },
//                onNavigateToMain = {
//                    navController.navigate(AppDestination.Main.route) {
//                        popUpTo(AppDestination.Splash.route) { inclusive = true }
//                    }
//                }
            )
        }


        // 인증 플로우
        navigation(
            startDestination = AuthDestination.Login.route,
            route = AppDestination.Auth.route
        ) {
            composable(AuthDestination.Login.route) {
                LoginScreen(
//                    onNavigateToRegister = {
//                        navController.navigate(AuthDestination.Register.route)
//                    },
//                    onNavigateToMain = {
//                        navController.navigate(AppDestination.Main.route) {
//                            popUpTo(AppDestination.Auth.route) { inclusive = true }
//                        }
//                    }
                )
            }

            composable(AuthDestination.Register.route) {
                RegisterScreen(
//                    onNavigateBack = {
//                        navController.popBackStack()
//                                     },
//                    onRegisterSuccess = {
//                        navController.navigate(AppDestination.Main.route) {
//                            popUpTo(AppDestination.Auth.route) { inclusive = true }
//                        }
//                    }
                )
            }
        }

        // 메인 앱 플로우
        composable(AppDestination.Main.route) {
            MainScreen(
                onNavigateToFeedCreate = {
                    navController.navigate(AppDestination.FeedCreate.route)
                },
                onNavigateToFeedDetail = {
                    navController.navigate(AppDestination.FeedDetail.route)
                }
            )
        }


        // 일정 가차
        navigation(
            startDestination = ScheduleGachaDestination.Step1.route,
            route = AppDestination.ScheduleGacha.route
        ) {
            composable(ScheduleGachaDestination.Step1.route) {
                ScheduleGachaScreen(
//                    onNavigateToStep2 = {
//                        navController.navigate(ScheduleGachaDestination.Step2.route)
//                    },
//                    onNavigateBack = { navController.popBackStack() }
                )
            }

        }

        // 일정 생성
        navigation(
            startDestination = ScheduleCreateDestination.Create.route,
            route = AppDestination.ScheduleCreate.route
        ) {
            composable(ScheduleCreateDestination.Create.route) {
                ScheduleCreateScreen(
//                    onNavigateToStep2 = {
//                        navController.navigate(ScheduleGachaDestination.Step2.route)
//                    },
//                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }

        // 피드 생성 ( 피드 -> 글추가' )
        navigation(
            startDestination = FeedCreateDestination.Step1.route,
            route = AppDestination.FeedCreate.route
        ) {
            composable(FeedCreateDestination.Step1.route) {
                FeedCreateScreen(
                    navController = navController
//                    onNavigateToStep2 = {
//                        navController.navigate(FeedCreateDestination.Step1.route)
//                    },
//                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }

        // 피드 자세히  ( 피드 -> 자세히보기)
        navigation(
            startDestination = FeedDetailDestination.Detail.route,
            route = AppDestination.FeedDetail.route
        ) {
            composable(FeedDetailDestination.Detail.route) {
                FeedDetailScreen(
                    navController = navController

//                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}