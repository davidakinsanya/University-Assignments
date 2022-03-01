package com.indieproject.client.msg

import com.indieproject.client.data.iot.Environment
import com.indieproject.client.data.iot.EnvironmentData
import com.indieproject.client.data.iot.Status
import com.indieproject.client.data.logs.EnvMetric
import com.indieproject.client.data.logs.EnvironmentLog
import com.indieproject.client.data.logs.MsgLog

// TODO: create multiple Enum classes to assist in
//  deciphering what the status data point means
//  as it pertains to the medical environment.


class EnvMsg constructor(private val env: EnvironmentData?) {

  fun evalEnvironmentLog(): EnvironmentLog {

    val envType = when(this.env!!.getEnvironment()) {
      Environment.PHARMACEUTICAL_STORAGE -> EnvMetric.PHARMACEUTICAL_STORAGE
      Environment.INCUBATOR -> EnvMetric.INCUBATOR
      Environment.PATIENT_WARD -> EnvMetric.PATIENT_WARD
      Environment.LAVATORY -> EnvMetric.LAVATORY
    }

    val log: MsgLog = if (this.env.getStatus() == Status.SUB_OPTIMAL) {
      MsgLog.SUB_OPTIMAL
    } else if (this.env.getStatus() == Status.MODERATE && this.env.getIdentifier() <= 6) {
      MsgLog.MODERATE
    } else if (this.env.getStatus() == Status.MODERATE && this.env.getIdentifier() > 6) {
      MsgLog.STANDARD
    } else if (this.env.getStatus() == Status.STANDARD && this.env.getIdentifier() <= 5) {
      MsgLog.STANDARD
    } else {
      MsgLog.SUB_OPTIMAL
    }

    return EnvironmentLog(envType, log)
  }

  fun generateLogMessage(log: EnvironmentLog): String {
    return "${log.getEnvMetric()} # ${this.env!!.getIdentifier()}: ${log.getLog().getStatus()}"
  }
}