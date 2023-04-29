package com.example.gmzucolo.marvel_app.di

import android.content.Context
import androidx.room.Room
import com.example.gmzucolo.marvel_app.data.local.MarvelDatabase
import com.example.gmzucolo.marvel_app.data.remote.ServiceApi
import com.example.gmzucolo.marvel_app.repository.MarvelRepository
import com.example.gmzucolo.marvel_app.repository.MarvelRepositoryImpl
import com.example.gmzucolo.marvel_app.util.Constants.DATABASE_NAME
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideMarvelDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MarvelDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideMarvelDao(database: MarvelDatabase) = database.marvelDao()

    @Provides
    fun bindMarvelRepository(
        service: ServiceApi
    ): MarvelRepository = MarvelRepositoryImpl(service)

}