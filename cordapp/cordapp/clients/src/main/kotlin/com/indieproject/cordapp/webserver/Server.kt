package com.indieproject.cordapp.webserver

import io.ktor.server.engine.*
import io.ktor.server.netty.*



fun main(args: Array<String>) {
    embeddedServer(Netty, port = 10050) {
        mainModule(args)
    }.start().addShutdownHook()
}

