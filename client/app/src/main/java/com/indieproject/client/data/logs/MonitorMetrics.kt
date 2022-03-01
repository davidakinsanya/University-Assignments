package com.indieproject.client.data.logs

enum class MonitorMetrics(private val metric: String) {
  PULSE("PULSE"), BP("BLOOD PRESSURE"),
  OS("OXYGEN SATURATION"), RESPIRATION("RESPIRATION"),
  TEMPERATURE("TEMPERATURE");

  fun getMetric(): String {
    return this.metric
  }
}