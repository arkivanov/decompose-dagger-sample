package com.example.myapplication.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.router.stack.active
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.example.myapplication.details.DetailsComponent
import com.example.myapplication.list.ListComponent
import com.example.myapplication.repository.Item
import com.example.myapplication.root.RootComponent.Child.DetailsChild
import com.example.myapplication.root.RootComponent.Child.ListChild
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class DefaultRootComponentTest {

    private val lifecycle = LifecycleRegistry()
    private val componentContext = DefaultComponentContext(lifecycle)

    private val root =
        DefaultRootComponent(
            listFactory = ::TestListComponent,
            detailsFactory = ::TestDetailsComponent,
            componentContext = componentContext,
        )

    @BeforeTest
    fun before() {
        lifecycle.resume()
    }

    @Test
    fun `WHEN created THEN list active`() {
        assertIs<ListChild>(activeChild())
    }

    @Test
    fun `WHEN list onItemSelected called THEN details active`() {
        activeChild<ListChild>().testComponent.onItemSelected("item")

        assertIs<DetailsChild>(activeChild())
        assertEquals("item", activeChild<DetailsChild>().testComponent.itemId)
    }

    @Test
    fun `GIVEN details active WHEN details onFinished called THEN list active`() {
        activeChild<ListChild>().testComponent.onItemSelected("item")

        activeChild<DetailsChild>().testComponent.onFinished()

        assertIs<ListChild>(activeChild())
    }

    private inline fun <reified T : RootComponent.Child> activeChild(): T =
        root.stack.active.instance as T

    private val ListChild.testComponent: TestListComponent
        get() = component as TestListComponent

    private val DetailsChild.testComponent: TestDetailsComponent
        get() = component as TestDetailsComponent

    private class TestListComponent(
        val componentContext: ComponentContext,
        val onItemSelected: (id: String) -> Unit,
    ) : ListComponent {
        override val items: Value<List<Item>> get() = error("Not yet implemented")
        override fun onItemClicked(id: String) {}
    }

    private class TestDetailsComponent(
        val componentContext: ComponentContext,
        val itemId: String,
        val onFinished: () -> Unit,
    ) : DetailsComponent {
        override val item: Value<Item> get() = error("Not yet implemented")
        override fun onCloseClicked() {}
    }
}