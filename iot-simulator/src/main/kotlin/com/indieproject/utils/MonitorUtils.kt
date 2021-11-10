package com.indieproject.utils

import kotlin.random.Random

class MonitorUtils {
  
  private fun setMonitorNumber(): Int {
    return Random.nextInt(1, 500)
  }
  
  private fun setPulse(): Int {
    return 0
  }
  
  private fun setBloodPressure(): String {
    return ""
  }
  
  private fun setRespiration(): Int {
    return 0
  }
  
  private fun setOxygenSaturation(): Int {
    return 0
  }
}