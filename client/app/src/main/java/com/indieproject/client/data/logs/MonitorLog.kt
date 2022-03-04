package com.indieproject.client.data.logs

data class MonitorLog(private val metrics: MonitorMetrics, private val log: MsgLog) {
  fun getMetric(): MonitorMetrics {
    return this.metrics
  }

  fun getLog(): MsgLog {
    return this.log
  }
}
