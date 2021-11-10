package com.indieproject.utils

import com.indieproject.data.MonitorData
import kotlin.random.Random

class MonitorUtils {
  
  fun setMonitorNumber(): Int {
    return Random.nextInt(1, 250)
  }
  
  fun setPulse(): Int {
    return Random.nextInt(70,100) // 60-100 normaL
  }
  
  fun setBloodPressure(): Array<Int> {
    return arrayOf(Random.nextInt(100,125), Random.nextInt(70,85)) // [90,60] - [120,80] normal
  }
  
  fun setRespiration(): Int {
    return Random.nextInt(12,25) // 12-25 normal
  }
  
  fun setOxygenSaturation(): Int {
    return Random.nextInt(85, 100) // 90-100 normal
  }
  
  fun setTemperature(): Double {
    return Random.nextDouble(36.0, 37.5) // 36.1-37.2 normal
  }
  
  fun generateMonitorObject(): MonitorData {
    return MonitorData(
      this.setMonitorNumber(),
      this.setPulse(),
      this.setBloodPressure(),
      this.setOxygenSaturation(),
      this.setRespiration(),
      this.setTemperature()
    )
  }
}