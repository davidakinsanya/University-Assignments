package com.indieproject.client.msg

import com.indieproject.client.data.MonitorData

class MonitorMsg constructor(private val mon: MonitorData) {

  fun evalPulse() {}
  fun evalBloodPressure() {}
  fun evalOxygenSaturation() {}
  fun evalRespiration() {}
  fun evalTemperature() {}
}