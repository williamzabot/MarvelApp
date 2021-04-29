package com.williamzabot.marvelapp.presentation.ui.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.williamzabot.marvelapp.domain.usecases.comics.ComicUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(private val comicUseCase: ComicUseCase): ViewModel() {

    val comics = Pager(
        config = PagingConfig(
            pageSize = 10,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { ComicsPagingSource(comicUseCase) }
    ).liveData.cachedIn(viewModelScope)

}