package com.twf.tritimings

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform