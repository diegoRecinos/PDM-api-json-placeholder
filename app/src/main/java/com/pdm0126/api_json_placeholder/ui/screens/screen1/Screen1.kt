package com.pdm0126.api_json_placeholder.ui.screens.screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Screen1(
    viewModel: Screen1ViewModel = viewModel()
    , onBack: () -> Unit) {
    Column {
        Row {
            Button(onClick = { viewModel.fetchPosts() }) { Text("GET Posts") }
            Button(onClick = { viewModel.createPost() }) { Text("POST (Crear)") }
        }

        if (viewModel.isLoading) {
            CircularProgressIndicator()
        }

        LazyColumn {
            items(viewModel.posts) { post ->
                Text(text = post.title, style = MaterialTheme.typography.titleMedium)
                Text(text = post.body)
                HorizontalDivider()
            }
        }
    }
}