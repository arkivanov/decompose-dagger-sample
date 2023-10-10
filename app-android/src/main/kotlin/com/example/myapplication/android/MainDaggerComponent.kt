package com.example.myapplication.android

import com.example.myapplication.root.DefaultRootComponent
import com.example.myapplication.root.RootModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RootModule::class])
interface MainDaggerComponent {

    val rootComponentFactory: DefaultRootComponent.Factory
}
