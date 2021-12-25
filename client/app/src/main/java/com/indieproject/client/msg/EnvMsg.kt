package com.indieproject.client.msg

import com.indieproject.client.data.EnvironmentData

class EnvMsg constructor(private val env: EnvironmentData) {
  fun evalStatus() {}
}