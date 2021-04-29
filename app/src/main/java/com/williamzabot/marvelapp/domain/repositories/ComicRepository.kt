package com.williamzabot.marvelapp.domain.repositories

import com.williamzabot.marvelapp.data.model.Comics
import com.williamzabot.marvelapp.domain.utils.Result

interface ComicRepository {
    suspend fun getComics(offset : Int) : Result<Comics>
}