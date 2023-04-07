package com.example.gmzucolo.marvel_app.di

import com.example.gmzucolo.marvel_app.data.remote.ServiceApi
import com.example.gmzucolo.marvel_app.repository.MarvelRepository
import com.example.gmzucolo.marvel_app.repository.MarvelRepositoryImpl
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@dagger.Module
object DataModule {

    @dagger.Provides
    fun bindMarvelRepository(
        service: ServiceApi
    ): MarvelRepository = MarvelRepositoryImpl(service)

}