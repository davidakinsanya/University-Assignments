package com.indieproject.client.repository

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.indieproject.client.data.iot.MonitorData
import com.indieproject.client.msg.MonitorMsg
import com.indieproject.client.requests.RetrofitInstance
import com.indieproject.client.view.MonitorDisplayObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MonitorRepository() {

  fun generateLogMessage(mon: MonitorData?) {
    val createMsg = MonitorMsg(mon)
    val msg = createMsg.generateLogMessage(createMsg.getLogList())
    pushLogMessage(mon!!,msg)
  }

  fun getDisplayLog() {

    RetrofitInstance.mon.getData().enqueue(object : Callback<MonitorData?> {
      override fun onResponse(call: Call<MonitorData?>, response: Response<MonitorData?>) {
        generateLogMessage(response.body())
      }

      override fun onFailure(call: Call<MonitorData?>, t: Throwable) {
        Log.d("Error", "GET REQUEST FAILED")
      }
    })
  }

  private fun pushLogMessage(mon: MonitorData, newMsg: String) {
    RetrofitInstance.monTwo.pushLogMessage(newMsg).enqueue(object : Callback<String?> {
      override fun onResponse(call: Call<String?>, response: Response<String?>) {
        // Log.d("success", "success")
      }

      override fun onFailure(call: Call<String?>, t: Throwable) {
        Log.d("Error", "POST REQUEST FAILED")
      }
    })
  }
}