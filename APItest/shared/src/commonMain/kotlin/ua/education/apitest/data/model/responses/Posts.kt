package ua.education.apitest.data.model.responses

import kotlinx.serialization.Serializable

@Serializable
internal data class Posts(
    val limit: Int,
    val posts: List<Post>,
    val skip: Int,
    val total: Int
)
