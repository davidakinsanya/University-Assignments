package com.indieproject.client.msg

import com.indieproject.client.data.MonitorData

// TODO: create multiple Enum classes to assist in
//  deciphering what each data point means
//  as it pertains to the patients health.


class MonitorMsg constructor(private val mon: MonitorData?) {

  fun evalPulse() {}
  fun evalBloodPressure() {}
  fun evalOxygenSaturation() {}
  fun evalRespiration() {}
  fun evalTemperature() {}


  fun generateLogMessage(): String {
    return ""
  }
}