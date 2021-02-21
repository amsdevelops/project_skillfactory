package com.amsdevelops.filmssearch.data

import com.amsdevelops.filmssearch.data.dao.FilmDao
import com.amsdevelops.filmssearch.data.entity.Film
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Flow<List<Film>> = filmDao.getCachedFilms()

}