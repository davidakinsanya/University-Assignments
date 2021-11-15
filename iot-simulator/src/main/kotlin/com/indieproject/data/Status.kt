package com.indieproject.data

import com.indieproject.utils.StatusUtils

enum class Status(val rate: Int) {
  SUB_OPTIMAL(StatusUtils().setRate()),
  MODERATE(StatusUtils().setRate()),
  STANDARD(StatusUtils().setRate()),
  OPTIMAL(StatusUtils().setRate())
}