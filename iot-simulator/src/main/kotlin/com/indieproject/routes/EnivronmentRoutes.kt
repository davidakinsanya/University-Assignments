package com.indieproject.routes

import com.indieproject.utils.EnvironmentUtils
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*

fun Application.environmentRoutes() {
  routing {
    post("/environment") {
      try {
        val utils = EnvironmentUtils()
        call.respond(utils.generateEnvironmentObject())
      } catch (B: BaseApplicationResponse.ResponseAlreadySentException) {}
    }
  }
}