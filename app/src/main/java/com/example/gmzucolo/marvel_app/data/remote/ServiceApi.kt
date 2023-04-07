package com.example.gmzucolo.marvel_app.data.remote

import com.example.gmzucolo.marvel_app.data.model.character.CharacterModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("characters")
    suspend fun listByStartsWith(
        @Query("nameStartsWith") nameStartWith: String? = null
    ): Response<CharacterModelResponse>

    @GET("characters")
    suspend fun allCharacters(
        @Query("offset") offset: Int? = 0
    ): Response<CharacterModelResponse>
}