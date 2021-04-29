package com.williamzabot.marvelapp.data.model

import com.google.gson.annotations.SerializedName

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    @SerializedName("results")
    val comics: List<Result>,
    val total: Int
)