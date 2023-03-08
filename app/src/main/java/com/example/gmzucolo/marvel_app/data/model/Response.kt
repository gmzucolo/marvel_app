package com.example.gmzucolo.marvel_app.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Response(
    @SerializedName("data")
    val data: Data
) : Serializable

data class Data(
    @SerializedName("total")
    val total: Int,
    @SerializedName("results")
    val results: List<Character>
) : Serializable

data class Character(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail
) : Serializable

data class Thumbnail(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
) : Serializable {
    val pathSec: String
        get() = path.replace("http:", "https:")
}
