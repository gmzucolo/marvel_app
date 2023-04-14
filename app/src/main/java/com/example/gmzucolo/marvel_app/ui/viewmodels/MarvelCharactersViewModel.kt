package com.example.gmzucolo.marvel_app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.gmzucolo.marvel_app.data.paging.MarvelApiPagingSource
import com.example.gmzucolo.marvel_app.repository.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MarvelCharactersViewModel @Inject constructor(
    repository: MarvelRepository
) : ViewModel() {
    val charactersPagedListFlow = Pager(
        PagingConfig(pageSize = MarvelApiPagingSource.PAGE_SIZE)
    ) {
        MarvelApiPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}