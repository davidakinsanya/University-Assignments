package com.indieproject.cordapp.webserver

import com.indieproject.cordapp.states.MsgState
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import net.corda.client.rpc.CordaRPCConnection

fun Application.msgRouting(conn: CordaRPCConnection) {
  routing {
    post("/msg/{newMsg}") {
      try {
        val msg: String? = call.parameters["newMsg"]
        if (msg != null) {
          val msgState: MsgState;
          // TODO: Initiate transaction.
        }
      } catch (b: BaseApplicationResponse.ResponseAlreadySentException) {}
    }
  }
}

