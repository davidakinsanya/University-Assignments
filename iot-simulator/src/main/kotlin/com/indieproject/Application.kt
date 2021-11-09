package com.indieproject

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.indieproject.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
