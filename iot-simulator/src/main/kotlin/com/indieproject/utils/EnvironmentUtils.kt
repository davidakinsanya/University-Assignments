package com.indieproject.utils

import com.indieproject.data.Status
import kotlin.random.Random

class EnvironmentUtils {
  fun setIdentifier(): Int {
    return Random.nextInt(1, 209)
  }
  
  fun setStatus(): Status {
    return Status.values().random()
  }
}