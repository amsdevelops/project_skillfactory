package com.amsdevelops.filmssearch.di.modules

import android.content.Context
import androidx.room.Room
import com.amsdevelops.filmssearch.data.MainRepository
import com.amsdevelops.filmssearch.data.dao.FilmDao
import com.amsdevelops.filmssearch.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFilmDao(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "film_db"
        ).build().filmDao()

    @Provides
    @Singleton
    fun provideRepository(filmDao: FilmDao) = MainRepository(filmDao)
}