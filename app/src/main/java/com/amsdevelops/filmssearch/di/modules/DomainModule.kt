package com.amsdevelops.filmssearch.di.modules

import android.content.Context
import com.amsdevelops.filmssearch.data.MainRepository
import com.amsdevelops.filmssearch.data.preferenes.PreferenceProvider
import com.amsdevelops.filmssearch.domain.Interactor
import dagger.Module
import dagger.Provides
import ru.devivanov.remote_module.TmdbApi
import javax.inject.Singleton

@Module
//Передаем контекст для SharedPreferences через конструктор
class DomainModule(val context: Context) {
    //Нам нужно контекст как-то провайдить, поэтому создаем такой метод
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    //Создаем экземпляр SharedPreferences
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}