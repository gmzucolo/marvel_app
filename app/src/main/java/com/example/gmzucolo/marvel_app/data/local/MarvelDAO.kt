package com.example.gmzucolo.marvel_app.data.local

import androidx.room.*
import com.example.gmzucolo.marvel_app.data.model.character.CharacterModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterModel: CharacterModel): Long

    @Query("SELECT * FROM characterModel ORDER BY id")
    fun getAll(): Flow<List<CharacterModel>>

    @Delete
    suspend fun delete(characterModel: CharacterModel)

}