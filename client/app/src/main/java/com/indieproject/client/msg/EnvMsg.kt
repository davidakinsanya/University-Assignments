package com.indieproject.client.msg

import com.indieproject.client.data.iot.Environment
import com.indieproject.client.data.iot.EnvironmentData
import com.indieproject.client.data.iot.Status
import com.indieproject.client.data.logs.EnvMetric
import com.indieproject.client.data.logs.EnvironmentLog
import com.indieproject.client.data.logs.MsgLog


class EnvMsg constructor(private val env: EnvironmentData?) {

  private fun evalType(): EnvMetric {
    return when(this.env!!.getEnvironment()) {
      Environment.PHARMACEUTICAL_STORAGE -> EnvMetric.PHARMACEUTICAL_STORAGE
      Environment.INCUBATOR -> EnvMetric.INCUBATOR
      Environment.PATIENT_WARD -> EnvMetric.PATIENT_WARD
      Environment.LAVATORY -> EnvMetric.LAVATORY
    }
  }

  private fun evalLog(): MsgLog {
    val log: MsgLog = if (this.env!!.getStatus() == Status.SUB_OPTIMAL) {
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

    return log
  }

  fun evalEnvironmentLog(): EnvironmentLog {
    return EnvironmentLog(evalType(), evalLog())
  }

  fun generateLogMessage(log: EnvironmentLog): String {
    return "${log.getEnvMetric().getMetric()} #${this.env!!.getIdentifier()}: ${log.getLog().getStatus()}"
  }
}