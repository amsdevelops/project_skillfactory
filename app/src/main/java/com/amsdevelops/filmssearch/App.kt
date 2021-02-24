package com.amsdevelops.filmssearch

import android.app.Application
import com.amsdevelops.filmssearch.di.AppComponent
import com.amsdevelops.filmssearch.di.DaggerAppComponent
import com.amsdevelops.filmssearch.di.modules.DatabaseModule
import com.amsdevelops.filmssearch.di.modules.DomainModule
import ru.devivanov.remote_module.DaggerRemoteComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        val remoteProvider = DaggerRemoteComponent.create()
        dagger = DaggerAppComponent.builder()
            .remoteProvider(remoteProvider)
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}