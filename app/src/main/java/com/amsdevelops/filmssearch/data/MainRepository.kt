package com.amsdevelops.filmssearch.data

import androidx.lifecycle.LiveData
import com.amsdevelops.filmssearch.data.dao.FilmDao
import com.amsdevelops.filmssearch.data.entity.Film
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        //Запросы в бд должны быть в отдельном потоке
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): LiveData<List<Film>> = filmDao.getCachedFilms()

}