package com.indieproject.client.repository

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.indieproject.client.`interface`.CardDemo
import com.indieproject.client.`interface`.EnvCard
import com.indieproject.client.data.iot.EnvironmentData
import com.indieproject.client.msg.EnvMsg
import com.indieproject.client.requests.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnvRepository {

  fun generateLogMessage(env: EnvironmentData?): @Composable () -> Unit {
    val createMsg = EnvMsg(env)
    val msg = createMsg.generateLogMessage(createMsg.evalEnvironmentLog())
    return pushLogMessage(env!!, msg)
  }

   fun getDisplayLog(): @Composable () -> Unit {
     var log: @Composable () -> Unit = {}
     RetrofitInstance.env.getData().enqueue(object : Callback<EnvironmentData?> {
       override fun onResponse(call: Call<EnvironmentData?>, response: Response<EnvironmentData?>) {
         log = generateLogMessage(response.body())
       }

       override fun onFailure(call: Call<EnvironmentData?>, t: Throwable) {
         Log.d("Error", "GET REQUEST FAILED")

       }
     })
     return log
   }

  private fun pushLogMessage(env: EnvironmentData, newMsg: String): @Composable () -> Unit {
    val demo: @Composable () -> Unit
   RetrofitInstance.envTwo.pushLogMessage(newMsg).enqueue(object : Callback<String?> {
     override fun onResponse(call: Call<String?>, response: Response<String?>) {
      Log.d("success", "success")
     }
     override fun onFailure(call: Call<String?>, t: Throwable) {

     }
   })
  return {
    EnvCard(env = env, msg = newMsg)
  }
  }
}