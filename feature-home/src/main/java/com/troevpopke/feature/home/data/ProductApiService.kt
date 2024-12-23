package com.troevpopke.feature.home.data

import com.troevpopke.common.models.Product
import com.troevpopke.feature.home.domain.Products
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): Products
    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: String): Product
}