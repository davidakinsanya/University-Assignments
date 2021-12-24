package com.indieproject.client.repository

import com.indieproject.client.data.MonitorData
import com.indieproject.client.requests.MonitorDataHandler
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MonitorRepository {

  object RetrieveMonitorData {
    val handler: MonitorDataHandler by lazy {
      Retrofit.Builder()
        .baseUrl("https://iot-simulator-iksj4.ondigitalocean.app")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MonitorDataHandler::class.java)
    }
  }

  fun getData(): Call<MonitorData> {
    return RetrieveMonitorData.handler.getData()
  }
}