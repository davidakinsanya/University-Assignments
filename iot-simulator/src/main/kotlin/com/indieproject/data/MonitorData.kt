package com.indieproject.data

data class MonitorData(
                       private val HeartRate: Int,
                       private val BloodPressure: String,
                       private val OxygenSaturation: Int,
                       private val Respiration: Int) {
  
  private val heartRate = this.HeartRate
  private val bloodPressure = this.BloodPressure
  private val oxygenSaturation = this.OxygenSaturation
  private val respiration = this.Respiration
  
  fun getHeartRate(): Int {
    return heartRate
  }
  
  fun getBloodPressure(): String {
    return bloodPressure
  }
  
  fun getOxygenSaturation(): Int {
    return oxygenSaturation
  }
  
  fun getRespiration(): Int {
    return respiration
  }
  
}
