package com.williamzabot.marvelapp.data.di

import com.williamzabot.marvelapp.data.repositories.ComicRepositoryImpl
import com.williamzabot.marvelapp.domain.repositories.ComicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun injectComicRepository(
        comicRepositoryImpl: ComicRepositoryImpl
    ): ComicRepository
}