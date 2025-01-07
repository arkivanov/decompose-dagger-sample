package com.example.myapplication.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.myapplication.repository.Item
import com.example.myapplication.repository.Repository
import com.example.myapplication.utils.AppScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import me.gulya.anvil.assisted.ContributesAssistedFactory

@ContributesAssistedFactory(AppScope::class, ListComponent.Factory::class)
class DefaultListComponent @AssistedInject constructor(
    repository: Repository,
    @Assisted componentContext: ComponentContext,
    @Assisted private val onItemSelected: (id: String) -> Unit,
) : ListComponent, ComponentContext by componentContext {

    override val items: Value<List<Item>> = MutableValue(repository.getItems())

    override fun onItemClicked(id: String) {
        onItemSelected(id)
    }
}
