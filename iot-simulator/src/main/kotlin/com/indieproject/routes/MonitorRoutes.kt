package com.indieproject.routes

import com.indieproject.data.MonitorData
import com.indieproject.utils.MonitorUtils
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.monitorRoutes() {
  routing {
    post("/monitor") {
      // val data = call.receive<MonitorData>()
      val utils = MonitorUtils()
      call.respond(utils.generateMonitorObject())
      call.respondText("Done!")
    }
  }
}