package com.pdm0126.api_json_placeholder.repository.PostRepository

import android.util.Log
import android.util.Log.e
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
//import com.pdm0126.api_json_placeholder.BuildConfig


class PostApiRepository(private val client: HttpClient): PostRepository {

    //private val BASE_URL = "${BuildConfig.BASE_URL}posts"

    override suspend fun getPosts(): Result<List<Post>> {

        return try {
            //intentar peticion
            val response: List<PostDTO> = client.get("posts").body()

            //success devolvemos lista de posts transformados
            Result.success(response.map { it.toModel() })

        } catch (e: Exception) {
            //devolver err
            Log.e("PostApiRepository", "Error fetching posts: ${e.message}", e)
            Result.failure(e)
        }

    }

    override suspend fun createPost(post: Post): Result<Post>{
        return try {
            val response: PostDTO = client.post("posts"){
                contentType(ContentType.Application.Json)
                setBody(post.toDTO())
            }.body()

            Result.success(response.toModel())

        } catch (e: Exception) {
            Log.e("PostApiRepository", "Error creating post: ${e.message}", e)
            Result.failure(e)
        }

    }

}