package com.example.gmzucolo.marvel_app.data.local

import androidx.room.TypeConverter
import com.example.gmzucolo.marvel_app.data.model.thumbnail.ThumbnailModel
import com.google.gson.Gson

class MarvelConverters {

    @TypeConverter
    fun fromThumbnail(thumbnailModel: ThumbnailModel): String = Gson().toJson(thumbnailModel)

    @TypeConverter
    fun toThumbnail(thumbnailModel: String): ThumbnailModel =
        Gson().fromJson(thumbnailModel, ThumbnailModel::class.java)
}