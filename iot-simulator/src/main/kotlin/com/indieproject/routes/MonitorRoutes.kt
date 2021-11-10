package com.indieproject.routes

import com.indieproject.utils.MonitorUtils
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*

fun Application.monitorRoutes()  {
  routing {
    post("/monitor") {
      try {
        val utils = MonitorUtils()
        call.respond(utils.generateMonitorObject())
      } catch(B : BaseApplicationResponse.ResponseAlreadySentException) {}
    }
  }
}
