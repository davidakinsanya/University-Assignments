package com.indieproject.client.requests

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

  val env: EnvDataHandler by lazy {
    Retrofit.Builder()
      .baseUrl("https://iot-simulator-iksj4.ondigitalocean.app")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(EnvDataHandler::class.java)
  }

  val mon: MonitorDataHandler by lazy {
    Retrofit.Builder()
      .baseUrl("https://iot-simulator-iksj4.ondigitalocean.app")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(MonitorDataHandler::class.java)
  }
}