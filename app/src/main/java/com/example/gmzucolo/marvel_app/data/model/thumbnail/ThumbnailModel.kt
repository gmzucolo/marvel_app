package com.example.gmzucolo.marvel_app.data.model.thumbnail

import com.google.gson.annotations.SerializedName


data class ThumbnailModel(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
)
