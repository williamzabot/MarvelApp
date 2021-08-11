package com.williamzabot.marvelapp.domain.repositories

import com.williamzabot.marvelapp.domain.model.Comic
import com.williamzabot.marvelapp.domain.utils.Result

interface ComicRepository {
    suspend fun getComics(offset : Int) : Result<List<Comic>>
}