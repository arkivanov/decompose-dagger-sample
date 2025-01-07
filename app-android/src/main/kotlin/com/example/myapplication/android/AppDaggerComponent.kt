package com.example.myapplication.android

import com.example.myapplication.root.RootComponent
import com.example.myapplication.utils.AppScope
import com.squareup.anvil.annotations.MergeComponent
import com.squareup.anvil.annotations.optional.SingleIn

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppDaggerComponent {

    val rootComponentFactory: RootComponent.Factory
}
