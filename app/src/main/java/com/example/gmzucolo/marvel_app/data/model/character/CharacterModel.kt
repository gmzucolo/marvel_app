package com.example.gmzucolo.marvel_app.data.model.character

import com.example.gmzucolo.marvel_app.data.model.thumbnail.ThumbnailModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CharacterModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("thumbnail")
    val thumbnailModel: ThumbnailModel
) : Serializable