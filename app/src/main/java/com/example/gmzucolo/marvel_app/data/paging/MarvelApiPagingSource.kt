package com.example.gmzucolo.marvel_app.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModel
import com.example.gmzucolo.marvel_app.data.remote.ServiceApi
import com.example.gmzucolo.marvel_app.repository.MarvelRepository
import okhttp3.OkHttpClient

class MarvelApiPagingSource(
    private val repository: MarvelRepository
) : PagingSource<Int, CharacterModel>() {
    override fun getRefreshKey(
        state: PagingState<Int, CharacterModel>
    ): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(
                anchorPosition
            )
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, CharacterModel> {
        return try {
            val page = params.key ?: 0
            val offset = page * PAGE_SIZE
            val response = repository.listAllCharacters(offset = offset)
            val nextKey =
                if (offset >= response.body()!!.data.total) null
                else page + 1
            return LoadResult.Page(
                data = response.body()!!.data.results,
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