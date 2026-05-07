package ua.education.platformspecific.data.about

expect class Platform(){
    val osName: String
    val osVersion: String
    val deviceModel: String
    val cpuType: String
    val screen: ScreenInfo

    fun logSystemInfo()
}

expect class ScreenInfo(){
    val width: Int
    val height: Int
    val density: Int?
}

val Platform.deviceInfo: String
    get(){
        val densityStr = screen.density?.let { "@${it}x" } ?: ""
        return "($osName; $osVersion; $deviceModel; ${screen.width}x${screen.height}$densityStr; $cpuType)"
}