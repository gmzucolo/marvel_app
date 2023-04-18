package com.example.gmzucolo.marvel_app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gmzucolo.marvel_app.data.model.comic.ComicModelResponse
import com.example.gmzucolo.marvel_app.repository.MarvelRepository
import com.example.gmzucolo.marvel_app.util.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailCharacterViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {

    private val _details =
        MutableStateFlow<ResourceState<ComicModelResponse>>(ResourceState.Loading())
    val details: StateFlow<ResourceState<ComicModelResponse>> = _details

    fun fetch(characterId: Int) = viewModelScope.launch { safeFetch(characterId) }

    private suspend fun safeFetch(characterId: Int) {
        _details.value = ResourceState.Loading()
        try {
            val response = repository.getComicsByCharacterId(characterId)
            _details.value = handleResponse(response)
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    _details.value = ResourceState.Error("No internet connection")
                }
                else -> {
                    _details.value = t.message.let { ResourceState.Error(it!!) }
                }
            }
        }
    }

    private fun handleResponse(
        response: Response<ComicModelResponse>
    ): ResourceState<ComicModelResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return ResourceState.Success(resultResponse)
            }
        }
        return ResourceState.Error(response.message())
    }
}
