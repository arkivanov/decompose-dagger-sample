package com.example.myapplication.details

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState

@Composable
fun DetailsContent(component: DetailsComponent, modifier: Modifier = Modifier) {
    val item by component.item.subscribeAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = item.title) },
                navigationIcon = {
                    IconButton(onClick = component::onCloseClicked) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Close button",
                        )
                    }
                },
            )
        },
    ) { paddingValues ->
        Text(
            text = item.text,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .verticalScroll(state = rememberScrollState())
                .padding(16.dp)
        )
    }
}
