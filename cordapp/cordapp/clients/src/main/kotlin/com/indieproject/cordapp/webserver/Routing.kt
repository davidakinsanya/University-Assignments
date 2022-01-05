package com.indieproject.cordapp.webserver

import com.indieproject.cordapp.states.MsgState
import io.ktor.application.*
import io.ktor.routing.*

fun Application.msgRouting() {
  routing {
    post("/msg/{newMsg}") {
      val msg: String? = call.parameters["newMsg"]
      if (msg != null) {
        val msgState: MsgState;
        // TODO: Initiate transaction.
      }
    }
  }
}

