package com.indieproject.data

import com.indieproject.utils.EnvironmentUtils

enum class Environment(val identifier: Int, val status: Status) {
  VACCINE_STORAGE(EnvironmentUtils().setIdentifier(), EnvironmentUtils().setStatus())
}