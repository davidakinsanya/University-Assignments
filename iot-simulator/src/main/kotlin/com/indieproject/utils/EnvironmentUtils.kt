package com.indieproject.utils

import com.indieproject.data.Environment
import com.indieproject.data.EnvironmentData
import com.indieproject.data.Status
import kotlin.random.Random

class EnvironmentUtils {
  private fun setIdentifier(): Int {
    return Random.nextInt(1, 109)
  }
  
  private fun setStatus(): Status {
    return Status.values().random()
  }
  
  private fun generateEnvironmentObject(): EnvironmentData {
    return EnvironmentData(Environment.values().random(),
      EnvironmentUtils().setIdentifier(),
      EnvironmentUtils().setStatus())
  }
}