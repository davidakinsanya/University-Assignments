package com.indieproject.data

data class MonitorData(
                       private val MonitorNumber: Int,
                       private val Pulse: Int,
                       private val BloodPressure: String,
                       private val OxygenSaturation: Int,
                       private val Respiration: Int,
                       private val Temperature: Int,
                       )

/*
{
  fun getMonitorNumber(): Int {
  return MonitorNumber
  }
  
  fun getPulse(): Int {
    return Pulse
  }

  fun getBloodPressure(): String {
    return BloodPressure
  }
  
  fun getOxygenSaturation(): Int {
    return OxygenSaturation
  }
  
  fun getRespiration(): Int {
    return Respiration
  }
  
  fun getTemperature(): Int {
    return Temperature
  }
}

*/

