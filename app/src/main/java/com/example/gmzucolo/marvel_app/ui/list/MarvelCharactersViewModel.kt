package com.example.gmzucolo.marvel_app.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.gmzucolo.marvel_app.data.paging.MarvelApiPagingSource
import com.example.gmzucolo.marvel_app.di.Module
import com.example.gmzucolo.marvel_app.repository.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MarvelCharactersViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {
    val charactersPagedListFlow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = MarvelApiPagingSource.PAGE_SIZE)
    ) {
//        MarvelApiPagingSource(MarvelApi.getService())
        MarvelApiPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}