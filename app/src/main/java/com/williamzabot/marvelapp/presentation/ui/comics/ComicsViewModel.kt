package com.williamzabot.marvelapp.presentation.ui.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.williamzabot.marvelapp.domain.usecases.ComicUseCase
import com.williamzabot.marvelapp.presentation.model.Comic
import kotlinx.coroutines.launch
import com.williamzabot.marvelapp.domain.utils.Result

class ComicsViewModel(private val comicUseCase: ComicUseCase) : ViewModel() {

    private val _viewState = MutableLiveData<ViewState>(ViewState.Running)
    val viewState: LiveData<ViewState> get() = _viewState

    private val _comics = MutableLiveData<List<Comic>>()
    val comics: LiveData<List<Comic>> get() = _comics

    fun getComics(offset: Int) {
        _viewState.postValue(ViewState.Loading)
        viewModelScope.launch {
            when (val result = comicUseCase.execute(offset)) {
                is Result.Success -> {
                    _comics.postValue(result.data.filter { it.image != null })
                    _viewState.postValue(ViewState.Running)
                }
                is Result.Failure -> {
                    _viewState.postValue(ViewState.Error)
                }
            }
        }
    }


    sealed class ViewState {
        object Running : ViewState()
        object Loading : ViewState()
        object Error : ViewState()
    }


}