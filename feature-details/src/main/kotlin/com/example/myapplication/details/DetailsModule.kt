package com.example.myapplication.details

import com.example.myapplication.repository.RepositoryModule
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule::class])
interface DetailsModule {

    @Binds
    fun componentFactory(impl: DefaultDetailsComponent.Factory): DetailsComponent.Factory
}
