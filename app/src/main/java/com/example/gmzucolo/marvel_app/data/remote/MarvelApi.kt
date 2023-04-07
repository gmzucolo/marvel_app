//package com.example.gmzucolo.marvel_app.data.remote
//
//import com.example.gmzucolo.marvel_app.di.Module.provideToMd5Hash
//import com.example.gmzucolo.marvel_app.util.Constants.APIKEY
//import com.example.gmzucolo.marvel_app.util.Constants.API_KEY
//import com.example.gmzucolo.marvel_app.util.Constants.PRIVATE_KEY
//import com.example.gmzucolo.marvel_app.util.Constants.PUBLIC_KEY
//import com.example.gmzucolo.marvel_app.util.Constants.TS
//import com.google.gson.GsonBuilder
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//import retrofit2.http.Query
//import java.math.BigInteger
//import java.security.MessageDigest
//import java.util.*
//
//interface MarvelApi {
//
//    @GET("characters")
//    suspend fun listByStartsWith(
//        @Query("nameStartsWith") nameStartWith: String? = null
//    ): retrofit2.Response<Response>
//
//    @GET("characters")
//    suspend fun allCharacters(
//        @Query("offset") offset: Int? = 0
//    ): Response
//
//    companion object {
//        const val API_KEY = "1c9a9078aa51928c6a1fc35082af9113"
//        const val PRIVATE_KEY = "90e2d0589a6b6675159cf2ddb031ea711968f0fc"
//        fun getService(): MarvelApi {
//            val logging = HttpLoggingInterceptor()
//            logging.level = HttpLoggingInterceptor.Level.BODY
//
//            val httpClient = OkHttpClient.Builder()
//            httpClient.addInterceptor(logging)
//            httpClient.addInterceptor { chain ->
//                val original = chain.request()
//                val originalHttpUrl = original.url
//                val ts = (Calendar.getInstance(
//                    TimeZone.getTimeZone("UTC")
//                ).timeInMillis / 1000L).toString()
//                val url = originalHttpUrl.newBuilder()
//                    .addQueryParameter(name = APIKEY, value = PUBLIC_KEY)
//                    .addQueryParameter(name = TS, value = ts)
//                    .addQueryParameter(
//                        "hash", provideToMd5Hash("$ts$PRIVATE_KEY$API_KEY")
//                    )
//                    .build()
//
//                chain.proceed(
//                    original.newBuilder().url(url).build()
//                )
//            }
//
//            val gson = GsonBuilder().setLenient().create()
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://gateway.marvel.com/v1/public/")
//                .addConverterFactory(
//                    GsonConverterFactory.create(gson)
//                )
//                .client(httpClient.build())
//                .build()
//
//    val gson = GsonBuilder().setLenient().create()
//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://gateway.marvel.com/v1/public/")
//        .addConverterFactory(
//            GsonConverterFactory.create(gson)
//        )
//        .client(httpClient.build())
//        .build()
//
//            return retrofit.create(MarvelApi::class.java)
//        }
//
//        private fun md5(input:String): String {
//            val md = MessageDigest.getInstance("MD5")
//            return BigInteger(1, md.digest(input.toByteArray()))
//                .toString(16)
//                .padStart(32, '0')
//        }
//    }
//}