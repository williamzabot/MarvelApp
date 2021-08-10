package com.williamzabot.marvelapp.data.repositories

import com.williamzabot.marvelapp.data.api.ComicsApi
import com.williamzabot.marvelapp.data.model.Comics
import com.williamzabot.marvelapp.domain.exceptions.UnauthorizedException
import com.williamzabot.marvelapp.domain.repositories.ComicRepository
import com.williamzabot.marvelapp.domain.utils.*

class ComicRepositoryImpl(private val comicsApi : ComicsApi): ComicRepository {

    override suspend fun getComics(offset: Int): Result<Comics> {
        val response = comicsApi.getComics(PUBLIC_KEY, HASH, TS, LIMIT, offset)
        return when (response.code()) {
            200 -> Result.Success(response.body()!!)
            401 -> Result.Failure(UnauthorizedException)
            else -> Result.Failure(Exception())
        }
    }
}