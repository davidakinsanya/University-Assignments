package com.indieproject.client.requests

import com.indieproject.client.data.MonitorData
import retrofit2.http.GET

interface MonitorDataHandler {

    @GET("/monitor")
    fun getData(): MonitorData
}