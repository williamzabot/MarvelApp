package com.williamzabot.marvelapp.data.api

import com.williamzabot.marvelapp.data.model.Comics
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicsApi {

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") ts: Int,
        @Query("limit") limit : Int,
        @Query("offset") offset: Int
    ) : Response<Comics>
}