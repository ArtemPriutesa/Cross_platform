package ua.education.platformspecific.data.about

import co.touchlab.kermit.Logger
import kotlinx.browser.window
import ua.education.platformspecific.parseBrowserName
import ua.education.platformspecific.parseOsName
import ua.education.platformspecific.parseOsVersion

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform actual constructor() {
    private val ua = window.navigator.userAgent ?: ""
    actual val osName: String
        get() = parseOsName(ua)

    actual val osVersion: String
        get() = parseOsVersion(ua)

    actual val deviceModel: String
        get() = "${parseBrowserName(ua)} (Browser)"

    actual val cpuType: String
        get() = window.navigator.hardwareConcurrency?.toString() ?: "---"

    actual val screen: ScreenInfo
        get() = ScreenInfo()

    actual fun logSystemInfo() {
        Logger.d(deviceInfo)
    }
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class ScreenInfo actual constructor() {

    actual val width: Int
        get() = window.screen.width

    actual val height: Int
        get() = window.screen.height

    actual val density: Int?
        get() = (window.devicePixelRatio * 160).toInt() // приблизний DPI
}