package com.amsdevelops.filmssearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amsdevelops.filmssearch.data.dao.FilmDao
import com.amsdevelops.filmssearch.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}