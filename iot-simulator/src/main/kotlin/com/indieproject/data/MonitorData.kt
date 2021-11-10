package com.indieproject.data

data class MonitorData(
                       private val MonitorNumber: Int,
                       private val Pulse: Int,
                       private val BloodPressure: Array<Int>,
                       private val OxygenSaturation: Int,
                       private val Respiration: Int,
                       private val Temperature: Int,
                       ) {

  fun getMonitorNumber(): Int {
  return MonitorNumber
  }
  
  fun getPulse(): Int {
    return Pulse
  }

  fun getBloodPressure(): Array<Int> {
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
  
  override fun toString(): String {
    return "Monitor #${this.getMonitorNumber()} reads: " +
            "\nPulse: ${this.getPulse()}" +
            "\nBlood Pressure: ${this.getBloodPressure()[0]}/${this.getBloodPressure()[1]}" +
            "\nOxygen Saturation: ${this.getOxygenSaturation()}" +
            "\n Resipration: ${this.getRespiration()}" +
            "\n Temperature: ${this.getTemperature()}"
  }
  
}

