package com.example.myapplication.list

import com.example.myapplication.repository.RepositoryModule
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule::class])
interface ListModule {

    @Binds
    fun componentFactory(impl: DefaultListComponent.Factory): ListComponent.Factory
}
