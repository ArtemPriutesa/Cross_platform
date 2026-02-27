package com.laba_1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform