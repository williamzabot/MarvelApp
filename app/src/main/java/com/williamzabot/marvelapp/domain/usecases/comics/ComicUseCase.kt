package com.williamzabot.marvelapp.domain.usecases.comics

import com.williamzabot.marvelapp.data.model.toComic
import com.williamzabot.marvelapp.domain.repositories.ComicRepository
import com.williamzabot.marvelapp.domain.usecases.base.BaseUseCase
import com.williamzabot.marvelapp.domain.utils.Result
import com.williamzabot.marvelapp.presentation.model.Comic
import javax.inject.Inject

class ComicUseCase @Inject constructor(private val comicRepository: ComicRepository) :
    BaseUseCase<List<Comic>, ComicUseCase.Params>() {

    data class Params(val offset: Int)

    override suspend fun execute(params: Params?): Result<List<Comic>> {
        if (params == null) throw IllegalArgumentException()
        return when (val result = comicRepository.getComics(params.offset)) {
            is Result.Success -> Result.Success(result.data.data.comics.map {
                it.toComic()
            })
            is Result.Failure -> Result.Failure(Exception())
        }
    }
}