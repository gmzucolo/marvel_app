package com.example.gmzucolo.marvel_app.repository

import com.example.gmzucolo.marvel_app.data.remote.ServiceApi
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val api: ServiceApi
) {
    suspend fun listByStartsWith(nameStartsWith: String? = null) =
        api.listByStartsWith(nameStartsWith)

    suspend fun listAllCharacters(offset: Int) = api.allCharacters(offset)

//    suspend fun getComics(characterId: Int) = api.getComics(characterId)
}