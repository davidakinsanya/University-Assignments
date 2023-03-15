package com.stockxsteals.server.controller

import com.stockxsteals.server.dao.api.*
import com.stockxsteals.server.dto.*
import com.stockxsteals.server.dto.api.Product
import com.stockxsteals.server.dto.api.Product360
import com.stockxsteals.server.dto.api.SneakerSearchResult
import com.stockxsteals.server.dto.api.Trend
import com.stockxsteals.server.dto.ui.Customer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import retrofit2.http.Query

@RestController
class DataController {
  
  @GetMapping("/search")
  fun sneakerSearch(@Query("productCode") productCode: String,
                    @Query("limit") limit: Int): List<SneakerSearchResult>? {
    
    return SneakerSearchDAO().executeSearch(productCode, limit)
  }
  
  @GetMapping("/product")
  fun productSearch(customer: Customer,
                    @Query("slug") slug: String,
                    @Query("currency") currency: String,
                    @Query("country") country: String): Product? {
    
    return ProductSearchDAO().executeSearch(customer, slug, currency, country)
  }
  
  @GetMapping("/product/activity")
  fun productActivitySearch(@Query("slug") slug: String,
                            @Query("type") type: String,
                    @Query("currency") currency: String,
                    @Query("country") country: String): ProductActivityData? {
    
    return ProductActivitySearchDAO().executeSearch(slug, type,  currency, country)
  }
  
  @GetMapping("/trends")
  fun getTrends(@Query("type") type: String,
                @Query("currency") currency: String): List<Trend>? {
    
    return TrendsDAO().getTrends(type, currency)
  }
  
  @GetMapping("/product/360")
  fun getProduct360(@Query("slug") slug: String): Product360? {
    return Product360DAO().executeSearch(slug)
  }
  
}