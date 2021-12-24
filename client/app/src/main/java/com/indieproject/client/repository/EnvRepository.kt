package com.indieproject.client.repository

import com.indieproject.client.requests.EnvDataHandler
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EnvRepository {

  object retrieveData {
    val handler: EnvDataHandler by lazy {
      Retrofit.Builder()
        .baseUrl("https://iot-simulator-iksj4.ondigitalocean.app")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(EnvDataHandler::class.java)
    }
  }



}