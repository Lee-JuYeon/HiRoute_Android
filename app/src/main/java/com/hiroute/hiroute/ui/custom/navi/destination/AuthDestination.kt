package com.hiroute.hiroute.ui.custom.navi.destination


// 인증 관련 화면
sealed class AuthDestination(val route: String) {
    object Login : AuthDestination("Login")
    object Register : AuthDestination("Register")
}
