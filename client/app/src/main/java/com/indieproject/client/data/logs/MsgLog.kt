package com.indieproject.client.data.logs

enum class MsgLog(private val status: String) {
  SUB_OPTIMAL("SUB_OPTIMAL"),
  MODERATE("MODERATE"),
  STANDARD("STANDARD"),
  OPTIMAL("OPTIMAL");

  fun getStatus(): String { return this.status }
}