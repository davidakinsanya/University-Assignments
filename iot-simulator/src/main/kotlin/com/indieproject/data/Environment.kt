package com.indieproject.data

import kotlinx.serialization.Serializable

@Serializable
enum class Environment() {
  PHARMACEUTICAL_STORAGE, PATIENT_WARD, INCUBATOR, LAVATORY;
}