package com.stockxsteals.server.dto.ui


data class Sneaker(val name: String, 
                   val sku: String,
                   val slug: String,
                   val desc: String, 
                   val last_sale: Int?,
                   val predicted_price: Float?,
                   val availability: Availability?,
                   val availability_diff: Int?,
                   val common_sizes: List<Int>?)
