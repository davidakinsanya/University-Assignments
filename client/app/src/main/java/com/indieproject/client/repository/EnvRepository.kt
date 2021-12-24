package com.indieproject.client.repository

import com.indieproject.client.data.EnvironmentData
import com.indieproject.client.requests.RetrofitInstance
import retrofit2.Call

class EnvRepository {

 fun getData(): Call<EnvironmentData> {
   return RetrofitInstance.env.getData()
 }
}