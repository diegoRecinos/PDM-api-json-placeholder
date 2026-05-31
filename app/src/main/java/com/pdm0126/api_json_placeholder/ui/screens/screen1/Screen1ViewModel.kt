package com.pdm0126.api_json_placeholder.ui.screens.screen1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.api_json_placeholder.data.model.Post
import com.pdm0126.api_json_placeholder.repository.PostRepository.PostRepository
import kotlinx.coroutines.launch

class Screen1ViewModel(private val repository: PostRepository) : ViewModel() {
    var posts by mutableStateOf<List<Post>>(emptyList())
    var isLoading by mutableStateOf(false)

    // Para el GET
    fun fetchPosts() {
        viewModelScope.launch {
            isLoading = true
            try {
                posts = repository.getPosts()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }

    // Para el POST
    fun createPost() {
        viewModelScope.launch {
            try {
                val newPost = Post(
                    userId = 1,
                    id = 0,
                    title = "title Post",
                    body = " POST body created with POST "
                )
                val result = repository.createPost(newPost)
                // Agregamos el resultado al inicio de la lista para verlo en pantalla
                posts = listOf(result) + posts
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
