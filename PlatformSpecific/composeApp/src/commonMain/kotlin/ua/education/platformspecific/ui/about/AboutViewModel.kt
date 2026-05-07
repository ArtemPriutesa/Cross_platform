package ua.education.platformspecific.ui.about

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ua.education.platformspecific.data.about.AboutRepository

@Stable
internal class AboutViewModel(
    private val aboutRepository: AboutRepository
) : ViewModel() {

    private val _state = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val state = _state.asStateFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            _state.value = aboutRepository.getAbout()
        }
    }
}

val aboutViewModelFactory = viewModelFactory {
    initializer {
        AboutViewModel(getAboutRepository())
    }
}

internal fun getAboutRepository(): AboutRepository = AboutRepository()