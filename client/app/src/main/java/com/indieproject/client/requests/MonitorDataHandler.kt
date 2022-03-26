package com.indieproject.client.requests

import com.indieproject.client.data.iot.MonitorData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MonitorDataHandler {

    @GET("/monitor")
    fun getData(): Call<MonitorData>

    @POST("/msg/{newMsg}")
    fun pushLogMessage(@Body newMsg: String): Call<String>
}