package com.indieproject

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.indieproject.plugins.*

/**
 * This program is tasked with running the server intended
 * to simulate a medical IOT device.
 *
 * @author David
 */
fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        configureSecurity()
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
