package com.indieproject.utils

import com.indieproject.data.Environment
import com.indieproject.data.EnvironmentData
import com.indieproject.data.Status
import kotlin.random.Random

/**
 * This class is tasked with feeding data to
 * and generating EnvironmentData objects.
 *
 * @author David
 */
class EnvironmentUtils {
  
  /**
   * This method generates a random integer
   * to be assigned as an environment identifier.
   *
   * @return a random integer between 900 and 3000.
   */
  fun setIdentifier(): Int {
    return Random.nextInt(900, 3000)
  }
  
  /**
   * 
   */
   fun setStatus(): Status {
    return Status.values().random()
  }
  
   fun generateEnvironmentObject(): EnvironmentData {
    return EnvironmentData(Environment.values().random(),
      EnvironmentUtils().setIdentifier(),
      EnvironmentUtils().setStatus())
  }
}