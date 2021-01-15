package com.amsdevelops.filmssearch

import android.app.Application
import com.amsdevelops.filmssearch.di.AppComponent
import com.amsdevelops.filmssearch.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.create()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}