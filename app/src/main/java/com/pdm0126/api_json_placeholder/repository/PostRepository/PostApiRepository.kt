package com.pdm0126.api_json_placeholder.repository.PostRepository

import com.pdm0126.api_json_placeholder.data.api.KtorClient
import com.pdm0126.api_json_placeholder.data.api.posts.PostDTO
import com.pdm0126.api_json_placeholder.data.api.posts.toDTO
import com.pdm0126.api_json_placeholder.data.api.posts.toModel
import com.pdm0126.api_json_placeholder.data.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.setBody
import io.ktor.http.*


class PostApiRepository(private val client: HttpClient): PostRepository {

    private val BASE_URL = "https://jsonplaceholder.typicode.com/posts"

    override suspend fun getPosts(): List<Post> {
        val response: List<PostDTO> = client.get(BASE_URL).body()
        return response.map { it.toModel() }
    }

    override suspend fun createPost(post: Post): Post{
        val response: PostDTO = client.post(BASE_URL){
            contentType(ContentType.Application.Json)
            setBody(post.toDTO())
        }.body()
        return response.toModel()
    }

}