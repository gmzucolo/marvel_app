package com.example.gmzucolo.marvel_app.repository

import com.example.gmzucolo.marvel_app.data.local.MarvelDAO
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModel
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelResponse
import com.example.gmzucolo.marvel_app.data.model.comic.ComicModelResponse
import com.example.gmzucolo.marvel_app.data.remote.ServiceApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface MarvelRepository {

    //Remote Repository
    suspend fun listByStartsWith(nameStartsWith: String?): Response<CharacterModelResponse>
    suspend fun listAllCharacters(offset: Int): Response<CharacterModelResponse>
    suspend fun getComicsByCharacterId(characterId: Int): Response<ComicModelResponse>

    //Local Repository
    suspend fun insertCharacter(characterModel: CharacterModel)
    suspend fun getAllCharacters()
    suspend fun deleteCharacter(characterModel: CharacterModel)
}

@Singleton
class MarvelRepositoryImpl @Inject constructor(
    private val api: ServiceApi,
    private val dao: MarvelDAO
) : MarvelRepository {

    override suspend fun listByStartsWith(nameStartsWith: String?) =
        api.listByStartsWith(nameStartsWith)

    override suspend fun listAllCharacters(offset: Int) = api.allCharacters(offset)

    override suspend fun getComicsByCharacterId(characterId: Int) =
        api.getComicsByCharacterId(characterId)

    override suspend fun insertCharacter(characterModel: CharacterModel) {
        dao.insert(characterModel)
    }

    override suspend fun getAllCharacters() {
        dao.getAll()
    }

    override suspend fun deleteCharacter(characterModel: CharacterModel) {
        dao.delete(characterModel)
    }

}
