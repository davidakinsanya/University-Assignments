package com.indieproject.client.msg

import com.indieproject.client.data.iot.MonitorData
import com.indieproject.client.data.logs.MonitorLog
import com.indieproject.client.data.logs.MonitorMetrics
import com.indieproject.client.data.logs.MsgLog

// TODO: create multiple Enum classes to assist in
//  deciphering what each data point means
//  as it pertains to the patients health.


class MonitorMsg constructor(private val mon: MonitorData?) {

  private fun evalPulse(): MonitorLog {
    val log: MonitorLog;
    when {
      mon!!.getPulse() <= 95 -> {
        log = MonitorLog(MonitorMetrics.PULSE, MsgLog.SUB_OPTIMAL)
      }
      mon.getPulse() in 75..85 -> {
        log = MonitorLog(MonitorMetrics.PULSE, MsgLog.STANDARD)
      }
      else -> {
        log = MonitorLog(MonitorMetrics.PULSE, MsgLog.OPTIMAL)
      }
    }
    return log
  }

  private fun evalBloodPressure(): MonitorLog {
    val log: MonitorLog = when {
      mon!!.getBloodPressure()[0] <= 115 && mon.getBloodPressure()[1] <= 85 -> {
        MonitorLog(MonitorMetrics.BP, MsgLog.SUB_OPTIMAL)
      }
      mon.getBloodPressure()[0] in 110..114 &&  mon.getBloodPressure()[1] in 80..84 -> {
        MonitorLog(MonitorMetrics.BP, MsgLog.STANDARD)
      }
      else -> {
        MonitorLog(MonitorMetrics.BP, MsgLog.OPTIMAL)
      }
    }

    return log
  }

  private fun evalOxygenSaturation(): MonitorLog {
    val log: MonitorLog = when {
      mon!!.getOxygenSaturation() <= 95 -> {
        MonitorLog(MonitorMetrics.OS, MsgLog.SUB_OPTIMAL)
      }
      mon.getOxygenSaturation() in 87..94 -> {
        MonitorLog(MonitorMetrics.OS, MsgLog.STANDARD)
      }
      else -> {
        MonitorLog(MonitorMetrics.OS, MsgLog.OPTIMAL)
      }
    }

    return log
  }

  private fun evalRespiration(): MonitorLog {
    val log: MonitorLog = when {
      mon!!.getRespiration() <= 13 -> {
        MonitorLog(MonitorMetrics.RESPIRATION, MsgLog.SUB_OPTIMAL)
      }
      mon.getRespiration() in 14..17 -> {
        MonitorLog(MonitorMetrics.RESPIRATION, MsgLog.STANDARD)
      }
      else -> {
        MonitorLog(MonitorMetrics.RESPIRATION, MsgLog.OPTIMAL)
      }
    }
    return log
  }

  fun evalTemperature(): MonitorLog {
    val log: MonitorLog = when {
      mon!!.getTemperature() <= 36.6 -> {
        MonitorLog(MonitorMetrics.TEMPERATURE, MsgLog.SUB_OPTIMAL)
      }
      mon.getTemperature() in 36.61..37.1 -> {
        MonitorLog(MonitorMetrics.TEMPERATURE, MsgLog.STANDARD)
      }
      else -> {
        MonitorLog(MonitorMetrics.TEMPERATURE, MsgLog.OPTIMAL)
      }
    }
    return log
  }

   fun getLogList(): List<MonitorLog> {
    return listOf(evalPulse(), evalBloodPressure(),
      evalOxygenSaturation(), evalRespiration(),
      evalTemperature()
    )
  }

  fun generateLogMessage(logList: List<MonitorLog>): String {
    var msg: String = "MONITOR #${mon!!.getMonitorNumber()}: "
    for (item in logList) {
      msg += "  ${item.getMetric()}: ${item.getLog().getStatus()}"
    }
    return msg
  }
}