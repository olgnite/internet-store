package com.troevpopke.feature_cart.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.troevpopke.common.models.Product
import com.troevpopke.common.ui.CommonHeader
import com.troevpopke.feature_cart.data.CartProduct

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = { CommonHeader(onBackClick = onBackClick) }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (state.size == 0) {
                item {
                    Text(
                        text = "В корзине пока ничего нет",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            } else {
                items(state, key = { it.product.id }) {
                    CartItem(
                        it,
                        onAddProduct = { viewModel.addProduct(it.product) },
                        onRemoveProduct = { viewModel.removeProduct(it) }
                    )
                }
            }
        }
    }
}

@Composable
fun CartItem(
    product: CartProduct,
    onAddProduct: (product: CartProduct) -> Unit,
    onRemoveProduct: (product: Product) -> Unit
) {
    OutlinedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AsyncImage(
                    modifier = Modifier.height(120.dp),
                    model = product.product.images[0],
                    contentDescription = null
                )
                Text(
                    text = product.product.title,
                    fontSize = 18.sp
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { onRemoveProduct(product.product) }) {
                    Icon(
                        Icons.Default.Clear,
                        null
                    )
                }
                Text(
                    text = product.count.toString(),
                    fontSize = 18.sp
                )
                IconButton(onClick = { onAddProduct(product) }) {
                    Icon(
                        Icons.Default.Add,
                        null
                    )
                }
            }
        }
    }
}