package com.indieproject.client.requests

import com.indieproject.client.data.iot.EnvironmentData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface EnvDataHandler {

    @GET("/environment")
    fun getData(): Call<EnvironmentData>

    @POST("/msg/{newMsg}")
    fun pushLogMessage(@Body newMsg: String): Call<String>
}