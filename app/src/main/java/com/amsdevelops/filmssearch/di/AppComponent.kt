package com.amsdevelops.filmssearch.di

import com.amsdevelops.filmssearch.di.modules.DatabaseModule
import com.amsdevelops.filmssearch.di.modules.DomainModule
import com.amsdevelops.filmssearch.viewmodel.HomeFragmentViewModel
import com.amsdevelops.filmssearch.viewmodel.SettingsFragmentViewModel
import dagger.Component
import ru.devivanov.remote_module.RemoteProvider
import javax.inject.Singleton

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    dependencies = [RemoteProvider::class],
    modules = [
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    //метод для того, чтобы появилась возможность внедрять зависимости в HomeFragmentViewModel
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    //метод для того, чтобы появилась возможность внедрять зависимости в SettingsFragmentViewModel
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}