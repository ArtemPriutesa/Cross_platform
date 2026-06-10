package ua.education.apitest.ui.presentation

import androidx.compose.runtime.Immutable
import ua.education.apitest.data.model.responses.Post

@Immutable
internal data class AppState(
    val isProgressVisible: Boolean = false,
    val posts: List<Post> = emptyList(),
    val result: String? = null,
    val error: String? = null,
)
