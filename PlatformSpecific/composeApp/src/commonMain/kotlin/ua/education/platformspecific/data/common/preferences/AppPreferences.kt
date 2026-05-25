package ua.education.platformspecific.data.common.preferences

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.getIntFlow
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

@OptIn(ExperimentalSettingsApi::class)
class AppPreferences(
    val settings: Settings,
    val observableSettings: ObservableSettings
) : Preferences {

    val aboutVisitedDateChannel = Channel<LastTimeScreenOpened>()

    override var aboutVisitedCount: Int
        get() = settings.get<Int>(PreferenceKey.ABOUT_VISITED_COUNT.key) ?: 0
        set(value) {
            settings.set(PreferenceKey.ABOUT_VISITED_COUNT.key, value)
        }

    override var aboutVisitedDate: LastTimeScreenOpened?
        get() = settings.get<LastTimeScreenOpened>(PreferenceKey.ABOUT_VISITED_DATE.key)
        set(value) {
            settings[PreferenceKey.ABOUT_VISITED_DATE.key] = value
            value?.let { aboutVisitedDateChannel.trySend(it) }
        }

    override val observableAboutVisitedCount: Flow<Int>
        get() = observableSettings.getIntFlow(PreferenceKey.ABOUT_VISITED_COUNT.key, 0)

    override val observableAboutVisitedDate: Flow<LastTimeScreenOpened>
        get() = aboutVisitedDateChannel.receiveAsFlow()

    override fun cleanStorage() {
        settings.clear()
    }
}