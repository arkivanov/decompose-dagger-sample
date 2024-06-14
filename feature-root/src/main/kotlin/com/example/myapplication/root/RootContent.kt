package com.example.myapplication.root

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.example.myapplication.details.DetailsContent
import com.example.myapplication.list.ListContent
import com.example.myapplication.root.RootComponent.Child.DetailsChild
import com.example.myapplication.root.RootComponent.Child.ListChild

@Composable
fun RootContent(component: RootComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.stack,
        modifier = modifier,
        animation = stackAnimation(animator = fade() + scale()),
    ) {
        when (val child = it.instance) {
            is ListChild -> ListContent(component = child.component, modifier = Modifier.fillMaxWidth())
            is DetailsChild -> DetailsContent(component = child.component, modifier = Modifier.fillMaxWidth())
        }
    }
}
