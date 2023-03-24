package com.example.gmzucolo.marvel_app.data.model.character

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CharacterModelData(
    @SerializedName("total")
    val total: Int,
    @SerializedName("results")
    val results: List<CharacterModel>
) : Serializable