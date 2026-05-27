package com.pdm0126.api_json_placeholder.repository.PostRepository

import com.pdm0126.api_json_placeholder.data.api.KtorClient
import com.pdm0126.api_json_placeholder.data.model.Post


class PostApiRepository : PostRepository {

    override suspend fun getPosts(): List<Post> {
        try {
            val response: GetPostResponseDto = KtorClient.client.get("movie/popular") {
                parameter("language", "es-ES")
                parameter("page", 1)
            }.body()

            return Result.success(response.results.map { movieDto -> movieDto.toModel() })
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun createPost(): Post{

    }

}