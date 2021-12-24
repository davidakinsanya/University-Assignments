package com.indieproject.client.repository

import com.indieproject.client.data.EnvironmentData
import com.indieproject.client.requests.EnvDataHandler
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EnvRepository {

  object RetrieveEnvData {
    val handler: EnvDataHandler by lazy {
      Retrofit.Builder()
        .baseUrl("https://iot-simulator-iksj4.ondigitalocean.app")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(EnvDataHandler::class.java)
    }
  }

 fun getData(): Call<EnvironmentData> {
   return RetrieveEnvData.handler.getData()
 }
}