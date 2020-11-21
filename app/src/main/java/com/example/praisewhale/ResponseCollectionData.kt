package com.example.praisewhale

data class ResponseCollectionData(
    val status : Int,
    val message : String,
    val data : Data
){
    data class Data(
        val id : Int,
        val daily_praise : String,
        val mission_praise : String
    )
}