package com.pdm0126.api_json_placeholder.repository.PostRepository

import com.pdm0126.api_json_placeholder.data.model.Post

interface PostRepository {

    suspend fun getPosts(): List<Post>
    suspend fun createPost(post: Post): Post

}