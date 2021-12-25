package com.indieproject.client.repository

import android.util.Log
import com.indieproject.client.data.MonitorData
import com.indieproject.client.msg.MonitorMsg
import com.indieproject.client.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MonitorRepository {

  fun generateLogMessage(mon: MonitorData?): String {
    val createMsg = MonitorMsg(mon)
    return createMsg.generateLogMessage()
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
}