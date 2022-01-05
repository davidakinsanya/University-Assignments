package com.indieproject.cordapp.webserver.routes

import com.indieproject.cordapp.flows.MsgFlowInitiator
import com.indieproject.cordapp.states.MsgState
import com.indieproject.cordapp.webserver.party.NetworkParty
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import net.corda.core.messaging.CordaRPCOps
import java.util.*

fun Application.msgRouting(proxy: CordaRPCOps) {
  routing {
    post("/msg/{newMsg}") {
      try {
        val msg: String? = call.parameters["newMsg"]
        val counterParty = NetworkParty().getPartyList().random()
        val name = proxy.wellKnownPartyFromX500Name(counterParty.name)
        if (msg != null) {
          val msgState: MsgState = MsgState(msg, counterParty);
          // val flow = proxy.startFlowDynamic().getReturnValue().get()
          // TODO: Initiate transaction.
        }
      } catch (b: BaseApplicationResponse.ResponseAlreadySentException) {}
    }
  }
}

