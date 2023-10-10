package com.example.myapplication.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.example.myapplication.repository.Item

interface ListComponent {

    val items: Value<List<Item>>

    fun onItemClicked(id: String)

    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            onItemSelected: (id: String) -> Unit,
        ): ListComponent
    }
}
