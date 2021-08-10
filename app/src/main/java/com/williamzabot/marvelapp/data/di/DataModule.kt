package com.williamzabot.marvelapp.data.di

import com.williamzabot.marvelapp.data.RetrofitClient.createWebService
import com.williamzabot.marvelapp.data.api.ComicsApi
import com.williamzabot.marvelapp.data.repositories.ComicRepositoryImpl
import com.williamzabot.marvelapp.domain.repositories.ComicRepository
import org.koin.dsl.module

val dataModule = module {

    single {
        createWebService<ComicsApi>()
    }

    factory<ComicRepository> {
        ComicRepositoryImpl(
            comicsApi = get()
        )
    }
}
