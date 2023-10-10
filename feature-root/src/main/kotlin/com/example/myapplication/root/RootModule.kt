package com.example.myapplication.root

import com.example.myapplication.details.DetailsModule
import com.example.myapplication.list.ListModule
import dagger.Binds
import dagger.Module

@Module(includes = [ListModule::class, DetailsModule::class])
interface RootModule {

    @Binds
    fun componentFactory(impl: DefaultRootComponent.Factory): RootComponent.Factory
}
