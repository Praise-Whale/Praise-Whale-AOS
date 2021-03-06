package com.sopt27.praisewhale.home.data

import com.google.gson.annotations.SerializedName


data class ResponseHomePraise(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val homePraise: HomePraise
    ) {
        data class HomePraise(
            val id: Int,
            @SerializedName("today_praise")
            val dailyPraise: String,
            @SerializedName("praise_description")
            val praiseDescription: String
        )
    }
}