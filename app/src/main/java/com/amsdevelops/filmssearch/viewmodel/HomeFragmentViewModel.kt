package com.amsdevelops.filmssearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amsdevelops.filmssearch.App
import com.amsdevelops.filmssearch.data.entity.Film
import com.amsdevelops.filmssearch.domain.Interactor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {
    //Инициализируем интерактор
    @Inject
    lateinit var interactor: Interactor
    val filmsListData: Flow<List<Film>>
    val showProgressBar: Channel<Boolean>

    init {
        App.instance.dagger.inject(this)
        showProgressBar = interactor.progressBarState
        filmsListData = interactor.getFilmsFromDB()
        getFilms()
    }

    fun getFilms() {
        interactor.getFilmsFromApi(1)
    }
}