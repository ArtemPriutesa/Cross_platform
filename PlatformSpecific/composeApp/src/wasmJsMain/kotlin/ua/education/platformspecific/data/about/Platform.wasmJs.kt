package ua.education.platformspecific.data.about

import co.touchlab.kermit.Logger
import kotlinx.browser.window

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform actual constructor() {

    actual val osName: String
        get() = window.navigator.platform ?: "Web"

    actual val osVersion: String
        get() = window.navigator.userAgent ?: "---"

    actual val deviceModel: String
        get() = "Browser"

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
        get() = (window.devicePixelRatio * 160).toInt()
}