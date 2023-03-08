package com.example.gmzucolo.marvel_app.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gmzucolo.marvel_app.data.model.Character
import com.example.gmzucolo.marvel_app.data.remote.MarvelApi

class MarvelApiPagingSource(
    private val marvelApi: MarvelApi,
) : PagingSource<Int, Character>() {
    override fun getRefreshKey(
        state: PagingState<Int, Character>
    ): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(
                anchorPosition
            )
            anchorPage?.prevKey?.plus(1) ?:
            anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 0
            val offset = page * PAGE_SIZE
            val response = marvelApi.allCharacters(offset = offset)
            val nextKey =
                if (offset >= response.data.total) null
                else page + 1
            return LoadResult.Page(
                data = response.data.results,
                prevKey = null, // Only paging forward.
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}