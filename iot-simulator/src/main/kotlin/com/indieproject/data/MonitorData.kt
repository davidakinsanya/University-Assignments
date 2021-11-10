package com.indieproject.data

import kotlinx.serialization.Serializable

@Serializable
data class MonitorData(
                       private val MonitorNumber: Int,
                       private val Pulse: Int,
                       private val BloodPressure: Array<Int>,
                       private val OxygenSaturation: Int,
                       private val Respiration: Int,
                       private val Temperature: Double,
                       ) {

  private fun getMonitorNumber(): Int {
  return MonitorNumber
  }
  
  private fun getPulse(): Int {
    return Pulse
  }

  private fun getBloodPressure(): Array<Int> {
    return BloodPressure
  }
  
  private fun getOxygenSaturation(): Int {
    return OxygenSaturation
  }
  
  private fun getRespiration(): Int {
    return Respiration
  }
  
  private fun getTemperature(): Double {
    return Temperature
  }
  
  override fun toString(): String {
    return "Monitor #${this.getMonitorNumber()} reads: " +
            "\n\nPulse: ${this.getPulse()} Beats Per Minute" +
            "\nBlood Pressure: ${this.getBloodPressure()[0]}/${this.getBloodPressure()[1]}mmHg" +
            "\nOxygen Saturation: ${this.getOxygenSaturation()}%" +
            "\nResipration: ${this.getRespiration()} Breaths Per Minute" +
            "\nTemperature: ${this.getTemperature()}°C"
  }
  
}
