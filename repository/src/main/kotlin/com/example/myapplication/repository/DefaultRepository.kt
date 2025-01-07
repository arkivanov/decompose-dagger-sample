package com.example.myapplication.repository

import com.example.myapplication.utils.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.optional.SingleIn
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
class DefaultRepository @Inject constructor() : Repository {

    private val itemMap: Map<String, Item> =
        List(100) { index ->
            Item(
                id = index.toString(),
                title = "Item $index",
                text = "Item $index. ".repeat(1000),
            )
        }.associateBy(Item::id)

    override fun getItems(): List<Item> =
        itemMap.values.toList()

    override fun getItem(id: String): Item =
        itemMap.getValue(key = id)
}
