package com.indieproject.client.requests

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

  private const val base_url = "https://iot-simulator-iksj4.ondigitalocean.app"

  val env: EnvDataHandler by lazy {
    Retrofit.Builder()
      .baseUrl(base_url)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(EnvDataHandler::class.java)
  }

  val mon: MonitorDataHandler by lazy {
    Retrofit.Builder()
      .baseUrl(base_url)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(MonitorDataHandler::class.java)
  }
}