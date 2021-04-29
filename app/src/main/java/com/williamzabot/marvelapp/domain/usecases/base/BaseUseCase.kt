package com.williamzabot.marvelapp.domain.usecases.base

import com.williamzabot.marvelapp.domain.utils.Result

abstract class BaseUseCase<T : Any, in Params> {
    abstract suspend fun execute(params: Params?): Result<T>
}