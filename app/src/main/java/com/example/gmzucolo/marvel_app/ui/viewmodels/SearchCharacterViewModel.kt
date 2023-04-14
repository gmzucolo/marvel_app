package com.example.gmzucolo.marvel_app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelResponse
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
class SearchCharacterViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {

    private val _searchCharacter =
        MutableStateFlow<ResourceState<CharacterModelResponse>>(ResourceState.Empty())
    val searchCharacter: StateFlow<ResourceState<CharacterModelResponse>> = _searchCharacter

    fun fetch(nameStartsWith: String) = viewModelScope.launch { safeFetch(nameStartsWith) }

    private suspend fun safeFetch(nameStartsWith: String?) {
        _searchCharacter.value = ResourceState.Loading()
        try {
            val response = repository.listByStartsWith(nameStartsWith)
            _searchCharacter.value = handleResponse(response)
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    _searchCharacter.value = ResourceState.Error("No internet connection")
                }
                else -> {
                    _searchCharacter.value = t.message.let { ResourceState.Error(it!!) }
                }
            }
        }

    }

    private fun handleResponse(
        response: Response<CharacterModelResponse>
    ): ResourceState<CharacterModelResponse> {

        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return ResourceState.Success(resultResponse)
            }
        }
        return ResourceState.Error(response.message())
    }

}
