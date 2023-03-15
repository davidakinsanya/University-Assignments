package com.stockxsteals.server.dto.ui

enum class Customer(val action: String, val size: Float?, val type: String?) {
  BUYER("buy", null, null),
  SELLER("sell", null, null)
}