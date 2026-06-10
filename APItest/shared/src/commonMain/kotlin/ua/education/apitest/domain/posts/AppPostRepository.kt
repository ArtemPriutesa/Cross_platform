package ua.education.apitest.domain.posts

import ua.education.apitest.data.model.requests.NewPost
import ua.education.apitest.data.model.responses.DeletedPost
import ua.education.apitest.data.model.responses.Post
import ua.education.apitest.data.model.responses.Posts
import ua.education.apitest.data.posts.NetworkResult
import ua.education.apitest.data.posts.PostApiService

internal class AppPostRepository(
    private val postApiService: PostApiService
): PostRepository {

    override suspend fun getAllPosts(): NetworkResult<Posts> {
        return postApiService.getAllPosts()
    }

    override suspend fun addPost(post: NewPost): NetworkResult<Post> {
        return postApiService.addPost(post)
    }

    override suspend fun updatePost(post: Post): NetworkResult<Post> {
        return postApiService.updatePost(post)
    }

    override suspend fun deletePost(postId: Int): NetworkResult<DeletedPost> {
        return postApiService.deletePost(postId)
    }
}
