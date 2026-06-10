package ua.education.apitest.domain.posts

import ua.education.apitest.data.model.requests.NewPost
import ua.education.apitest.data.model.responses.DeletedPost
import ua.education.apitest.data.model.responses.Post
import ua.education.apitest.data.model.responses.Posts
import ua.education.apitest.data.posts.NetworkResult

internal interface PostRepository {
    suspend fun getAllPosts(): NetworkResult<Posts>
    suspend fun addPost(post: NewPost): NetworkResult<Post>
    suspend fun updatePost(post: Post): NetworkResult<Post>
    suspend fun deletePost(postId: Int): NetworkResult<DeletedPost>
}