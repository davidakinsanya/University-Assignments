package com.indieproject.data

import kotlinx.serialization.Serializable

@Serializable
data class EnvironmentData(private val environment: Environment, private val identifier: Int, private val status: Status) {
  
  private fun getIdentifier(): Int {
    return identifier
  }
  
  private fun getStatus(): Status {
    return status
  }
  
  private fun getEnvironment(): Environment {
    return environment
  }
  
  override fun toString(): String {
    return "${this.getEnvironment()} #${this.getIdentifier()} " +
            "Condition reads as ${this.getStatus()} " +
            "(${this.getStatus().getRate()}/10)"
  }
}
