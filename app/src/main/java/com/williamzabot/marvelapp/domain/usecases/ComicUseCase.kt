package com.williamzabot.marvelapp.domain.usecases

import com.williamzabot.marvelapp.data.model.toComic
import com.williamzabot.marvelapp.domain.repositories.ComicRepository
import com.williamzabot.marvelapp.domain.utils.Result
import com.williamzabot.marvelapp.domain.model.Comic

class ComicUseCase(private val comicRepository: ComicRepository) {

    suspend fun execute(offset : Int): Result<List<Comic>> {
        return when (val result = comicRepository.getComics(offset)) {
            is Result.Success -> Result.Success(result.data.data.comics.map {
                it.toComic()
            })
            is Result.Failure -> Result.Failure(result.exception)
        }
    }
}