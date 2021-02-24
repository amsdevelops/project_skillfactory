package ru.devivanov.remote_module

interface RemoteProvider {
    fun provideRemote(): TmdbApi
}