package ua.education.apitest.data.posts

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import ua.education.apitest.data.model.requests.NewPost
import ua.education.apitest.data.model.responses.DeletedPost
import ua.education.apitest.data.model.responses.Post
import ua.education.apitest.data.model.responses.Posts

internal const val BASE_URL = "https://dummyjson.com/"
internal const val POSTS_API = "posts"

internal const val ADD_POST = "add"

sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val message: String, val exception: Exception? = null) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()
}

suspend inline fun <reified T> HttpClient.safeRequest(
    block: HttpClient.() -> HttpResponse
): NetworkResult<T> {
    return try {
        val response = block()
        if (response.status.isSuccess()) {
            NetworkResult.Success(response.body())
        } else {
            NetworkResult.Error("Error: ${response.status.value}")
        }
    } catch (e: Exception) {
        NetworkResult.Error(e.message ?: "Unknown error", e)
    }
}

internal interface PostApiService {
    suspend fun getAllPosts(): NetworkResult<Posts>
    suspend fun addPost(post: NewPost): NetworkResult<Post>
    suspend fun updatePost(post: Post): NetworkResult<Post>
    suspend fun deletePost(postId: Int): NetworkResult<DeletedPost>
}