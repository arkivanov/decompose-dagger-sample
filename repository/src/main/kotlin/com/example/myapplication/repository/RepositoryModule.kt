package com.example.myapplication.repository

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun repository(impl: DefaultRepository): Repository
}
