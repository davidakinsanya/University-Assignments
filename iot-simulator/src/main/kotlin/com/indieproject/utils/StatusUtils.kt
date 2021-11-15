package com.indieproject.utils

import kotlin.random.Random

class StatusUtils {
  fun setRate(): Int {
    return Random.nextInt(1, 10)
  }
}