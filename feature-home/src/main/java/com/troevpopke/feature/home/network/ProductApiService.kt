package com.troevpopke.feature.home.network

import com.troevpopke.common.models.Product
import com.troevpopke.common.models.Products
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): Products
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: String): Product
}