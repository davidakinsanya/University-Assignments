package com.indieproject.client.repository

import android.util.Log
import androidx.compose.runtime.Composable
import com.indieproject.client.`interface`.CardDemo
import com.indieproject.client.data.iot.MonitorData
import com.indieproject.client.msg.MonitorMsg
import com.indieproject.client.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MonitorRepository {

  fun generateLogMessage(mon: MonitorData?): @Composable () -> Unit {
    val createMsg = MonitorMsg(mon)
    val msg = createMsg.generateLogMessage(createMsg.getLogList())
    return pushLogMessage(mon!!,msg)
  }

  fun getDisplayLog(): @Composable () -> Unit {
    var log: @Composable () -> Unit = {}
    RetrofitInstance.mon.getData().enqueue(object : Callback<MonitorData?> {
      override fun onResponse(call: Call<MonitorData?>, response: Response<MonitorData?>) {
        log = generateLogMessage(response.body())
      }

      override fun onFailure(call: Call<MonitorData?>, t: Throwable) {
        Log.d("Error", "GET REQUEST FAILED")
      }
    })
    return log
  }

  private fun pushLogMessage(mon: MonitorData, newMsg: String): @Composable () -> Unit {
    val demo: @Composable () -> Unit
    RetrofitInstance.monTwo.pushLogMessage(newMsg).enqueue(object : Callback<String?> {
      override fun onResponse(call: Call<String?>, response: Response<String?>) {

      }

      override fun onFailure(call: Call<String?>, t: Throwable) {

      }
    })
    return {
      CardDemo(mon = mon, env = null, msg = newMsg)
    }
  }
}