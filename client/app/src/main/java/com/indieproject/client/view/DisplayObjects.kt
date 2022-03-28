package com.indieproject.client.view

import com.indieproject.client.data.iot.EnvironmentData
import com.indieproject.client.data.iot.MonitorData

data class MonitorDisplayObject(private var mon: MonitorData, private var newMsg: String) {
  fun getObject(): MonitorData {
    return mon
  }

  fun getMessage(): String {
    return newMsg
  }

  fun setObject(mon: MonitorData) {
    this.mon = mon
  }
  fun setMessage(newMsg: String) {
    this.newMsg = newMsg
  }
}


data class EnvironmentDisplayObject(private val env: EnvironmentData, private val newMsg: String) {
  fun getObject(): EnvironmentData {
    return env
  }

  fun getMessage(): String {
    return newMsg
  }
}


