package com.example.gmzucolo.marvel_app.data.model.comic

import com.example.gmzucolo.marvel_app.data.model.Thumbnail
import com.google.gson.annotations.SerializedName

data class ComicModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail
) : java.io.Serializable
