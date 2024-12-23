package com.troevpopke.feature_details.data

import com.troevpopke.common.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductDetailsRepository {

    val product: Flow<Product>

    fun requestProductById(id: String)

}