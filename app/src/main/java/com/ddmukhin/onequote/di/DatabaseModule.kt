package com.ddmukhin.onequote.di

import com.ddmukhin.onequote.persistence.Database
import com.ddmukhin.onequote.persistence.paper.PaperDatabase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    fun provideDatabase(): Database = PaperDatabase()

}