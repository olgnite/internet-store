package com.troevpopke.feature_cart.ui

import androidx.lifecycle.ViewModel
import com.troevpopke.common.models.Product
import com.troevpopke.feature_cart.data.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: CartRepository
) : ViewModel() {

    sealed interface State {
        data class Content(val list: List<Product>) : State
    }

    val state = repository.getProducts()

    public fun addProduct(product: Product) {
        repository.addProduct(product)
    }

    public fun removePreoduct(id: String) {
        repository.removeProduct(id)
    }
}
