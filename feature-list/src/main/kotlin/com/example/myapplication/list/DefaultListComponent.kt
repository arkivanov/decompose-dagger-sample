package com.example.myapplication.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.myapplication.repository.Item
import com.example.myapplication.repository.Repository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DefaultListComponent @AssistedInject internal constructor(
    repository: Repository,
    @Assisted componentContext: ComponentContext,
    @Assisted private val onItemSelected: (id: String) -> Unit,
) : ListComponent, ComponentContext by componentContext {

    override val items: Value<List<Item>> = MutableValue(repository.getItems())

    override fun onItemClicked(id: String) {
        onItemSelected(id)
    }

    @AssistedFactory
    interface Factory : ListComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            onItemSelected: (id: String) -> Unit,
        ): DefaultListComponent
    }
}
