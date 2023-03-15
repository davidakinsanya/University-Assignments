package com.stockxsteals.server.http

import com.stockxsteals.server.dto.*
import com.stockxsteals.server.dto.api.Product
import com.stockxsteals.server.dto.api.Product360
import com.stockxsteals.server.dto.api.SneakerSearchResult
import com.stockxsteals.server.dto.api.Trend
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface RetrofitHandler {
  
  companion object {
    const val api_key = "b41046cf42mshb3b498b5572d856p1ca3e7jsn906143e03733"
    const val api_host = "stockx1.p.rapidapi.com"
    
  }
  
  @Headers("X-RapidAPI-Key: $api_key", "X-RapidAPI-Host: $api_host")
  @GET("search")
  fun searchSneaker(@Query("query") productCode: String,
                    @Query("limit") limit: Int): Call<List<SneakerSearchResult>>
  
  
  @Headers("X-RapidAPI-Key: $api_key", "X-RapidAPI-Host: $api_host")
  @GET("product")
  fun searchProduct(@Query("query") slug: String,
                    @Query("currency") currency: String,
                    @Query("country") country: String): Call<Product>
  
  
  @Headers("X-RapidAPI-Key: $api_key", "X-RapidAPI-Host: $api_host")
  @GET("product/activity")
  fun searchProductActivity(@Query("query") slug: String,
                            @Query("type") type: String, // bid,ask,sale
                    @Query("currency") currency: String,
                    @Query("country") country: String): Call<ProductActivityData>
  
  
  @Headers("X-RapidAPI-Key: $api_key", "X-RapidAPI-Host: $api_host")
  @GET("trends")
  fun getTrends(@Query("query") type: String,
                @Query("currency") currency: String): Call<List<Trend>>
  
  
  @Headers("X-RapidAPI-Key: $api_key", "X-RapidAPI-Host: $api_host")
  @GET("product/360")
  fun getProduct360(@Query("query") slug: String): Call<Product360>
}