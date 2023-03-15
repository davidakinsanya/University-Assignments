package com.stockxsteals.server.dao.api

import com.stockxsteals.server.dto.api.Product
import com.stockxsteals.server.dto.ui.Availability
import com.stockxsteals.server.dto.ui.Customer
import com.stockxsteals.server.dto.ui.Sneaker
import com.stockxsteals.server.http.RetrofitInstance

class ProductSearchDAO {
  
  fun executeSearch(customer: Customer,
                    slug: String,
                    currency: String,
                    country: String): Product? {
    
    val res = RetrofitInstance.productSearchVariable.searchProduct(slug, currency, country).execute()
    
    return if (res.isSuccessful) cleanUp(res.body()!!)
    else {
      println(res.errorBody())
      return null
    }
  }
  
  private fun cleanUp(product: Product): Product {
    product.description = product.description.replace("\n<br>\n<br>\n", "\n")
    return product
  }
  
  private fun getAvailability(asks: Int, bids: Int): Availability {
    return if (asks > bids) Availability.SURPLUS;
    else Availability.SHORTAGE;
  }
  
  private fun returnSneaker(product: Product, customer: Customer): Sneaker {
    
    if (customer.size != null) {
      for (variant in product.variants) {
        for (size in variant.sizes) {
          if (customer.type == size.type && size.size.contains(customer.size.toString())) {
            
            val asks = variant.market.bids.num_asks
            val bids = variant.market.bids.num_bids
            val diff = asks - bids
            
            return Sneaker(product.name,
              product.sku,
              product.slug,
              product.description,
              variant.market.sales.last_sale,
              variant.market.sales.last_sale * (1 - variant.market.sales.change_percent),
              getAvailability(asks, bids),
              diff,
              null,
            )
          }
        }
      }
    }
  
    val asks = product.market.bids.num_asks
    val bids = product.market.bids.num_bids
    val diff = asks - bids
    
    return Sneaker(product.name,
                   product.sku,
                   product.slug,
                   product.description,
                   product.market.sales.last_sale,
      product.market.sales.last_sale * (1 - product.market.sales.change_percent),
                   getAvailability(asks, bids),
                   diff,
      null,
    )
  }
}