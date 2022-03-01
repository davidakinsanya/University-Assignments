package com.indieproject.client.data.logs

data class EnvironmentLog(private val env: EnvMetric, private val log: MsgLog) {

  fun getEnvMetric(): EnvMetric {
    return this.env
  }

  fun getLog(): MsgLog {
    return this.log
  }
}
