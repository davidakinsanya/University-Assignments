package com.indieproject.client.repository

import android.util.Log
import com.indieproject.client.data.iot.MonitorData
import com.indieproject.client.msg.MonitorMsg
import com.indieproject.client.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MonitorRepository {

  fun generateLogMessage(mon: MonitorData?) {
    val createMsg = MonitorMsg(mon)
    val msg = createMsg.generateLogMessage(createMsg.getLogList())
    pushLogMessage(msg)
  }

  fun getData() {
    RetrofitInstance.mon.getData().enqueue(object : Callback<MonitorData?> {
      override fun onResponse(call: Call<MonitorData?>, response: Response<MonitorData?>) {
        generateLogMessage(response.body())
      }

      override fun onFailure(call: Call<MonitorData?>, t: Throwable) {
        Log.d("Error", "GET REQUEST FAILED")
      }
    })
  }

  private fun pushLogMessage(newMsg: String) {
    RetrofitInstance.monTwo.pushLogMessage(newMsg).enqueue(object : Callback<String?> {
      override fun onResponse(call: Call<String?>, response: Response<String?>) {

      }

      override fun onFailure(call: Call<String?>, t: Throwable) {

      }
    })
  }
}