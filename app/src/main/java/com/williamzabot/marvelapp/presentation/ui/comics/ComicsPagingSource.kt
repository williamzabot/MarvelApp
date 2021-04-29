package com.williamzabot.marvelapp.presentation.ui.comics

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.williamzabot.marvelapp.domain.usecases.comics.ComicUseCase
import com.williamzabot.marvelapp.domain.utils.LIMIT
import com.williamzabot.marvelapp.presentation.model.Comic
import retrofit2.HttpException
import java.io.IOException
import com.williamzabot.marvelapp.domain.utils.Result

class ComicsPagingSource(private val comicUseCase: ComicUseCase) : PagingSource<Int, Comic>() {
    override fun getRefreshKey(state: PagingState<Int, Comic>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comic> {
        val offset = params.key ?: 1
        return try {
            when (val result = comicUseCase.execute(ComicUseCase.Params(offset))) {
                is Result.Success -> LoadResult.Page(
                    data = result.data.filter { it.image != null },
                    prevKey = null,
                    nextKey = offset + LIMIT
                )
                is Result.Failure -> LoadResult.Error(result.exception)
            }
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}