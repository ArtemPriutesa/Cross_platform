package ua.education.platformspecific.ui.about

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.education.platformspecific.data.about.AboutRepository
import ua.education.platformspecific.data.common.preferences.AppPreferences

@Stable
internal class AboutViewModel(
    private val aboutRepository: AboutRepository
) : ViewModel() {

    val countState: StateFlow<Int> = aboutRepository.visitedCountObservable()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 0
        )

    private val _state = MutableStateFlow(AboutState())
    val state = _state.asStateFlow()

    init {
        Logger.w("init")
        aboutRepository.increaseVisitCount()
    }

    fun fetchData() {
        viewModelScope.launch {
            val platformInfo = aboutRepository.getAbout()
            val visitedCount = aboutRepository.visitedCount()

            _state.update { current ->
                current.copy(
                    platformInfo = platformInfo,
                    visitedCount = visitedCount
                )
            }
        }
    }
}
