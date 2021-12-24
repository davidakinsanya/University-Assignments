package com.indieproject.client.requests

import com.indieproject.client.data.EnvironmentData
import retrofit2.http.GET

interface EnvDataHandler {

    @GET("/environment")
    fun getData(): EnvironmentData
}