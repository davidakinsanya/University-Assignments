package com.indieproject

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.indieproject.plugins.*
import com.indieproject.routes.monitorRoutes
import com.indieproject.test.MonitorTesting

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        configureSecurity()
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
