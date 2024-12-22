package com.troevpopke.feature_cart.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.troevpopke.common.models.Product

@Composable
fun CartScreen(
    viewModel: CartViewModel =  hiltViewModel(),
    onAddProduct: (product: Product) -> Unit,
    onRemoveProduct: (id: String) -> Unit
) {



}