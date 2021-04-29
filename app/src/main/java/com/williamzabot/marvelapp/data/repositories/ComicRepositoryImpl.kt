package com.williamzabot.marvelapp.data.repositories

import com.williamzabot.marvelapp.data.di.RetrofitModule
import com.williamzabot.marvelapp.data.model.Comics
import com.williamzabot.marvelapp.domain.repositories.ComicRepository
import com.williamzabot.marvelapp.domain.utils.*
import javax.inject.Inject

class ComicRepositoryImpl @Inject constructor() : ComicRepository {

    private val comicsApi = RetrofitModule.getComicsApi()

    override suspend fun getComics(offset: Int): Result<Comics> {
        val response = comicsApi.getComics(PUBLIC_KEY, HASH, TS, LIMIT, offset)
        return when (response.code()) {
            200 -> Result.Success(response.body()!!)
            else -> Result.Failure(Exception())
        }
    }
}