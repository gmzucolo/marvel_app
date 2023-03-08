package com.example.gmzucolo.marvel_app.data.remote

import com.example.gmzucolo.marvel_app.data.model.Response
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

interface MarvelApi {

    @GET("characters")
    suspend fun listByStartsWith(
        @Query("nameStartsWith") nameStartWith: String? = null
    ): retrofit2.Response<Response>

    @GET("characters")
    suspend fun allCharacters(
        @Query("offset") offset: Int? = 0
    ): Response

    companion object {
        const val API_KEY = "SUA_PUBLIC_KEY"
        const val PRIVATE_KEY = "SUA_PRIVATE_KEY"
        fun getService(): MarvelApi {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url
                val ts = (Calendar.getInstance(
                    TimeZone.getTimeZone("UTC")
                ).timeInMillis / 1000L).toString()
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("ts", ts)
                    .addQueryParameter(
                        "hash", md5("$ts$PRIVATE_KEY$API_KEY")
                    )
                    .build()

                chain.proceed(
                    original.newBuilder().url(url).build()
                )
            }

            val gson = GsonBuilder().setLenient().create()
            val retrofit = Retrofit.Builder()
                .baseUrl("http://gateway.marvel.com/v1/public/")
                .addConverterFactory(
                    GsonConverterFactory.create(gson)
                )
                .client(httpClient.build())
                .build()

            return retrofit.create(MarvelApi::class.java)
        }

        private fun md5(input:String): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray()))
                .toString(16)
                .padStart(32, '0')
        }
    }
}