package com.indieproject.client.data.logs

enum class EnvMetric(private val env: String) {
  PHARMACEUTICAL_STORAGE("PHARMACEUTICAL STORAGE"), PATIENT_WARD("PATIENT WARD"),
  INCUBATOR("INCUBATOR"), LAVATORY("LAVATORY");

  fun getMetric(): String {
    return this.env
  }
}