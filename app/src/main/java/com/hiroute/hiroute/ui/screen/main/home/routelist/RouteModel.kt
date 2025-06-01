package com.hiroute.hiroute.ui.screen.main.home.routelist

data class RouteModel(
    val id: Int,
    val title: String,
    val duration: String,
    val places: List<String>,
    val rating: Float,
    val image: String = "📍"
)
