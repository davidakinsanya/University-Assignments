package com.indieproject.data

import com.indieproject.utils.EnvironmentUtils

enum class Environment(private val identifier: Int, private val status: Status) {
  VACCINE_STORAGE(EnvironmentUtils().setIdentifier(), EnvironmentUtils().setStatus());
  
  fun getIdentifier(): Int {
    return identifier
  }
  
  fun getStatus(): Status {
    return status
  }
}