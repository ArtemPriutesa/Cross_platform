package ua.education.platformspecific.data.about

import kotlin.math.max
import kotlin.math.min

internal class AboutRepository {

    fun getAbout(): MutableList<Pair<String, String>> {
        val platform = Platform()

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
}