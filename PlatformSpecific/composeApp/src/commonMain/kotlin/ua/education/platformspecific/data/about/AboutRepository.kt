package ua.education.platformspecific.data.about

import kotlinx.coroutines.flow.Flow
import ua.education.platformspecific.data.common.preferences.Preferences
import kotlin.math.max
import kotlin.math.min

internal class AboutRepository(
    private val platform: Platform,
    private val preferences: Preferences
) {

    fun getAbout(): MutableList<Pair<String, String>> {

        val items = mutableListOf(
            Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
            Pair("Device", platform.deviceModel),
            Pair("CPU", platform.cpuType)
        )

        val max = max(platform.screen.width, platform.screen.height)
        val min = min(platform.screen.width, platform.screen.height)

        var displayInfo = "${max}×${min}"
        platform.screen.density?.let {
            displayInfo += " ${it}x"
        }
        items.add(Pair("Display", displayInfo))
        return items
    }
    fun increaseVisitCount() {
        preferences.aboutVisitedCount++
    }

    fun visitedCount(): Int {
        return preferences.aboutVisitedCount
    }

    fun visitedCountObservable(): Flow<Int> {
        return preferences.observableAboutVisitedCount
    }
}