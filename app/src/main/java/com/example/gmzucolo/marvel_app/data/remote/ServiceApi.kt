package com.example.gmzucolo.marvel_app.data.remote

import com.example.gmzucolo.marvel_app.data.model.comic.ComicModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @GET("characters")
    suspend fun listByStartsWith(
        @Query("nameStartsWith") nameStartWith: String? = null
    ): Response<com.example.gmzucolo.marvel_app.data.model.Response>

    @GET("characters")
    suspend fun listAllCharacters(
        @Query("offset") offset: Int? = 0
    ): Response<com.example.gmzucolo.marvel_app.data.model.Response>

    @GET("characters/{characterId}/comics")
    suspend fun getComics(
        @Path(
            value = "characterId",
            encoded = true
        ) characterId: Int
    ): Response<ComicModelResponse>
}