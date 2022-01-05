package com.indieproject.cordapp.webserver

import com.indieproject.cordapp.webserver.utils.addShutdownHook
import com.indieproject.cordapp.webserver.utils.mainModule
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main(args: Array<String>) {
    embeddedServer(Netty, port = 10050) {
        mainModule(args)
    }.start().addShutdownHook()
}

