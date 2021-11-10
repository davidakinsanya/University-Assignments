package com.indieproject.utils

import kotlin.random.Random

class MonitorUtils {
  
  fun setMonitorNumber(): Int {
    return Random.nextInt(1, 500)
  }
  
  fun setPulse(): Int {
    return Random.nextInt(45,120) // 60-100 normaL
  }
  
  fun setBloodPressure(): Array<Int> {
    return arrayOf(Random.nextInt(80,140), Random.nextInt(50,90)) // [90,60] - [120,80] normal
  }
  
  fun setRespiration(): Int {
    return Random.nextInt(10,30) // 12-25 normal
  }
  
  fun setOxygenSaturation(): Int {
    return Random.nextInt(85, 100) // 90-100 normal
  }
  
  fun setTemperature(): Double {
    return Random.nextDouble(36.0, 38.0) // 36.1-37.2 normal
  }
}