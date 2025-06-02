package com.hiroute.hiroute.model

import java.util.Date

data class FeedEventModel(
    val uid : String,
    val tiem : Date,
    val location : String,
    var description : String,
    var photoUrlList : List<String>
){

}