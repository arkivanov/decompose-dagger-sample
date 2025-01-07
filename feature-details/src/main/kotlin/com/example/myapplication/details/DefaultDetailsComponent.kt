package com.example.myapplication.details

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.myapplication.repository.Item
import com.example.myapplication.repository.Repository
import com.example.myapplication.utils.AppScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import me.gulya.anvil.assisted.ContributesAssistedFactory

@ContributesAssistedFactory(AppScope::class, DetailsComponent.Factory::class)
class DefaultDetailsComponent @AssistedInject constructor(
    repository: Repository,
    @Assisted componentContext: ComponentContext,
    @Assisted itemId: String,
    @Assisted private val onFinished: () -> Unit,
) : DetailsComponent, ComponentContext by componentContext {

    override val item: Value<Item> = MutableValue(repository.getItem(id = itemId))

    override fun onCloseClicked() {
        onFinished()
    }
}
