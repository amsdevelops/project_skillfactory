package com.amsdevelops.filmssearch.di.modules

import com.amsdevelops.filmssearch.data.MainRepository
import com.amsdevelops.filmssearch.data.TmdbApi
import com.amsdevelops.filmssearch.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}