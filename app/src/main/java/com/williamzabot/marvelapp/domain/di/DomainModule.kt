package com.williamzabot.marvelapp.domain.di

import com.williamzabot.marvelapp.domain.usecases.ComicUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        ComicUseCase(
            comicRepository = get()
        )
    }
}