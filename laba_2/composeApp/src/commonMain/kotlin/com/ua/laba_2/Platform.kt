package com.ua.laba_2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform