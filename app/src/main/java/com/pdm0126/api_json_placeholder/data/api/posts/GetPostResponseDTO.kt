package com.pdm0126.api_json_placeholder.data.api.posts

import kotlinx.serialization.Serializable


@Serializable
data class getPostResponseDTO(
    val page: Int? = null,
    val results: List<PostDTO>,
)