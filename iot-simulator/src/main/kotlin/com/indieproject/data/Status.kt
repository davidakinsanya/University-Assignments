package com.indieproject.data

import com.indieproject.utils.StatusUtils
import kotlinx.serialization.Serializable

@Serializable
enum class Status(private val rate: Int) {
  SUB_OPTIMAL(StatusUtils().setRate()),
  MODERATE(StatusUtils().setRate()),
  STANDARD(StatusUtils().setRate()),
  OPTIMAL(StatusUtils().setRate());
  
  fun getRate(): Int {
    return rate
  }
}