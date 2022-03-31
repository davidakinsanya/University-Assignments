package com.indieproject.client.repository

import android.util.Log
import com.indieproject.client.data.iot.MonitorData
import com.indieproject.client.db.CardModel
import com.indieproject.client.db.DbHelper
import com.indieproject.client.msg.MonitorMsg
import com.indieproject.client.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MonitorRepository() {

  fun generateLogMessage(mon: MonitorData?, db: DbHelper) {
    val createMsg = MonitorMsg(mon)
    val msg = createMsg.generateLogMessage(createMsg.getLogList())
    pushLogMessage(mon!!, db, msg, createMsg.getDangerStatus())
  }

  fun logData(db: DbHelper) {
    RetrofitInstance.mon.getData().enqueue(object : Callback<MonitorData?> {
      override fun onResponse(call: Call<MonitorData?>, response: Response<MonitorData?>) {
        generateLogMessage(response.body(), db)
      }

      override fun onFailure(call: Call<MonitorData?>, t: Throwable) {
        Log.d("Error", "GET REQUEST FAILED")
      }
    })
  }

  private fun pushLogMessage(mon: MonitorData, db: DbHelper, newMsg: String, danger: Boolean) {
    RetrofitInstance.monTwo.pushLogMessage(newMsg).enqueue(object : Callback<String?> {
      override fun onResponse(call: Call<String?>, response: Response<String?>) {
        db.addCard(CardModel().createCard(mon.getMonitorNumber(), "MON", newMsg, danger))
      }

      override fun onFailure(call: Call<String?>, t: Throwable) {
        Log.d("Error", "POST REQUEST FAILED")
      }
    })
  }
}