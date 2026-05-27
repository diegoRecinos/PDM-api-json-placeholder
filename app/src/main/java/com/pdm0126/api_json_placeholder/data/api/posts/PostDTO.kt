package com.pdm0126.api_json_placeholder.data.api.posts

import com.pdm0126.api_json_placeholder.data.model.Post


data class PostDTO(

){

}

fun PostDTO.toModel(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}
