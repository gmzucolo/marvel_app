package com.example.gmzucolo.marvel_app.repository

import com.example.gmzucolo.marvel_app.data.remote.MarvelApi
import com.example.gmzucolo.marvel_app.data.remote.ServiceApi
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val api: MarvelApi
) {
    suspend fun listByStartsWith(nameStartsWith: String? = null) = api.listByStartsWith(nameStartsWith)

//    suspend fun listAllCharacters(offset: Int) = api.listAllCharacters(offset)
//
//    suspend fun getComics(characterId: Int) = api.getComics(characterId)
}