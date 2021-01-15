package com.amsdevelops.filmssearch.di.modules

import com.amsdevelops.filmssearch.data.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideRepository() = MainRepository()
}