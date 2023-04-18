package com.example.gmzucolo.marvel_app.repository

import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelResponse
import com.example.gmzucolo.marvel_app.data.model.comic.ComicModelResponse
import com.example.gmzucolo.marvel_app.data.remote.ServiceApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface MarvelRepository {

    suspend fun listByStartsWith(nameStartsWith: String?): Response<CharacterModelResponse>
    suspend fun listAllCharacters(offset: Int): Response<CharacterModelResponse>
    suspend fun getComicsByCharacterId(characterId: Int): Response<ComicModelResponse>

}

@Singleton
class MarvelRepositoryImpl @Inject constructor(
    private val api: ServiceApi
) : MarvelRepository {

    override suspend fun listByStartsWith(nameStartsWith: String?) =
        api.listByStartsWith(nameStartsWith)

    override suspend fun listAllCharacters(offset: Int) = api.allCharacters(offset)

    override suspend fun getComicsByCharacterId(characterId: Int) =
        api.getComicsByCharacterId(characterId)

}
