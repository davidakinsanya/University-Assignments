package com.indieproject.client.repository

import com.indieproject.client.data.MonitorData
import com.indieproject.client.requests.RetrofitInstance
import retrofit2.Call


class MonitorRepository {

  fun getData(): Call<MonitorData> {
    return RetrofitInstance.mon.getData()
  }
}