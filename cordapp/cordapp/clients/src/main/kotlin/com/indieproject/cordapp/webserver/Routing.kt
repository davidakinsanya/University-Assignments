package com.indieproject.cordapp.webserver

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.msgRouting() {
  routing {
    post("/msg/{newMsg}") {
      call.respond("Hello World")
    }
  }
}

