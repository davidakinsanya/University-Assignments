package com.indieproject.client.msg

import com.indieproject.client.data.EnvironmentData

// TODO: create multiple Enum classes to assist in
//  deciphering what the status data point means
//  as it pertains to the medical environment.


class EnvMsg constructor(private val env: EnvironmentData?) {

  fun evalStatus() {}



  fun generateLogMessage(): String {
    return ""
  }
}