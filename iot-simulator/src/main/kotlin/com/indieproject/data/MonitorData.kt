package com.indieproject.data

data class MonitorData(
                       private val MonitorNumber: Int,
                       private val HeartRate: Int,
                       private val BloodPressure: String,
                       private val OxygenSaturation: Int,
                       private val Respiration: Int)

/*
{
  
  fun getHeartRate(): Int {
    return HeartRate
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
  
  fun getMonitorNumber(): Int {
  return MonitorNumber
  }
}

*/

