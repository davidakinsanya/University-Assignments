package com.indieproject.routes

import com.indieproject.utils.MonitorUtils
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.monitorRoutes() {
  routing {
    post("/monitor") {
      val utils = MonitorUtils()
      call.respond(utils.generateMonitorObject())
      call.respondText("Done!")
    }
  }
}