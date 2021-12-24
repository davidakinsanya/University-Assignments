package com.indieproject.client.repository

import android.util.Log
import com.indieproject.client.data.EnvironmentData
import com.indieproject.client.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnvRepository {

   fun getData() {
     var responseBody: EnvironmentData? = null;
     RetrofitInstance.env.getData().enqueue(object : Callback<EnvironmentData?> {
       override fun onResponse(call: Call<EnvironmentData?>, response: Response<EnvironmentData?>) {
        responseBody = response.body()
         //Log.d("Success", responseBody.toString())
       }

       override fun onFailure(call: Call<EnvironmentData?>, t: Throwable) {
         Log.d("Error", "GET REQUEST FAILED")
       }
     })
   }
}