package com.williamzabot.marvelapp.presentation.di

import com.williamzabot.marvelapp.presentation.ui.comics.ComicsViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val presentationModule = module{
    viewModel {
        ComicsViewModel(
            comicUseCase = get()
        )
    }

}
