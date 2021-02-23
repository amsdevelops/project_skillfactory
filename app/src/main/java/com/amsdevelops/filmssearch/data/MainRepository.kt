package com.amsdevelops.filmssearch.data

import com.amsdevelops.filmssearch.data.dao.FilmDao
import com.amsdevelops.filmssearch.data.entity.Film
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

}