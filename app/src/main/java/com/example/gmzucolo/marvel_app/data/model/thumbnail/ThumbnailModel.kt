package com.example.gmzucolo.marvel_app.data.model.thumbnail

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ThumbnailModel(
    @SerializedName("path")
    val path: String,
    @SerializedName("extension")
    val extension: String
) : Serializable {
    val pathSec: String
        get() = path.replace("http:", "https:")
}
