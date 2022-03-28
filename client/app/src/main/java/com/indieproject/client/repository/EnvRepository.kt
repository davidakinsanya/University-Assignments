package com.indieproject.client.repository

import android.util.Log
import com.indieproject.client.data.iot.EnvironmentData
import com.indieproject.client.msg.EnvMsg
import com.indieproject.client.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnvRepository {

  fun generateLogMessage(env: EnvironmentData?) {
    val createMsg = EnvMsg(env)
    val msg = createMsg.generateLogMessage(createMsg.evalEnvironmentLog())
    pushLogMessage(env!!, msg)
  }

   fun getDisplayLog() {
     RetrofitInstance.env.getData().enqueue(object : Callback<EnvironmentData?> {
       override fun onResponse(call: Call<EnvironmentData?>, response: Response<EnvironmentData?>) {
         generateLogMessage(response.body())
       }

       override fun onFailure(call: Call<EnvironmentData?>, t: Throwable) {
         Log.d("Error", "GET REQUEST FAILED")

       }
     })
   }

  private fun pushLogMessage(env: EnvironmentData, newMsg: String) {
    RetrofitInstance.envTwo.pushLogMessage(newMsg).enqueue(object : Callback<String?> {
      override fun onResponse(call: Call<String?>, response: Response<String?>) {
        Log.d("success", "success")
      }

      override fun onFailure(call: Call<String?>, t: Throwable) {
        Log.d("Error", "POST REQUEST FAILED")
      }
    })
  }
}