package com.example.myapplication.repository

import javax.inject.Inject

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
