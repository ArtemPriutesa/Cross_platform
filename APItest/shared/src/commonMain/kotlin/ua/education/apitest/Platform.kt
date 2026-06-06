package ua.education.apitest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform