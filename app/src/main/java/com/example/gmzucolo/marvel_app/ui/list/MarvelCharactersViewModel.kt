package com.example.gmzucolo.marvel_app.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.gmzucolo.marvel_app.data.paging.MarvelApiPagingSource
import com.example.gmzucolo.marvel_app.data.remote.MarvelApi
import javax.inject.Inject

class MarvelCharactersViewModel @Inject constructor () : ViewModel() {
    val charactersPagedListFlow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = MarvelApiPagingSource.PAGE_SIZE)
    ) {
        MarvelApiPagingSource(MarvelApi.getService())
    }.flow.cachedIn(viewModelScope)
}