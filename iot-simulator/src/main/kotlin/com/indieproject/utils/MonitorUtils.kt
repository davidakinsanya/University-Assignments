package com.indieproject.utils

import kotlin.random.Random

class MonitorUtils {
  
  private fun setMonitorNumber(): Int {
    return Random.nextInt(1, 500)
  }
  
  private fun setPulse(): Int {
    return Random.nextInt(45,120) // 60-100 normaL
  }
  
  private fun setBloodPressure(): Array<Int> {
    return arrayOf(Random.nextInt(80,140), Random.nextInt(50,90)) // [90,60] - [120,80] normal
  }
  
  private fun setRespiration(): Int {
    return Random.nextInt(10,30) // 12-25 normal
  }
  
  private fun setOxygenSaturation(): Int {
    return Random.nextInt(85, 100) // 90-100 normal
  }
  
  private fun setTemperature(): Double {
    return Random.nextDouble(36.0,38.0) // 36.1-37.2 normal
  }
}