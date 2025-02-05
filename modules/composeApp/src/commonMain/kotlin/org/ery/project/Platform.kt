package org.ery.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform