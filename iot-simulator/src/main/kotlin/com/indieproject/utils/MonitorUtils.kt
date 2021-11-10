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
    return arrayOf(Random.nextInt(99,120), Random.nextInt(75,90)) // [90,60] - [120,80] normal
  }
  
  fun setRespiration(): Int {
    return Random.nextInt(12,20) // 10-20 normal
  }
  
  fun setOxygenSaturation(): Int {
    return Random.nextInt(85, 100)
  }
  
  fun setTemperature(): Double {
    return Random.nextDouble(36.485, 37.901)
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