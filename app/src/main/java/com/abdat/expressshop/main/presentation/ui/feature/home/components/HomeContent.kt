package com.abdat.expressshop.main.presentation.ui.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdat.expressshop.main.domain.model.response.Product
import com.abdat.expressshop.main.presentation.ui.feature.home.HomeScreenUiState
import com.abdat.expressshop.main.presentation.ui.theme.ExpressShopTheme

@Composable
fun HomeContent(
    featured: List<Product> ,
    popularProducts: List<Product> ,
    categories: List<String> ,
    loadingState: Boolean ,
    errorState: String? ="" ,
    onClick: (Product) -> Unit,
    ) {
    LazyColumn {

        item {
            if (loadingState) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(68.dp))
                    Text(text = "loading...", style = MaterialTheme.typography.bodyMedium)
                }
            }
            errorState?.let {
                Text(text = it, style = MaterialTheme.typography.bodyMedium)
            }
            if (categories.isNotEmpty()) {
                Spacer(Modifier.padding(16.dp))
                LazyRow {
                    items(homeUiState.categories) {
                        Text(
                            text = it.apply { replaceFirstChar { it.uppercase() } },
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.primary)
                                .padding(8.dp),

                            )
                    }
                }
                Spacer(Modifier.padding(16.dp))
            }
        }
        item {
            if (featured.isNotEmpty()) {
                HomeProductRow(products = featured, title = "Featured", onClick = onClick)
                Spacer(modifier = Modifier.size(16.dp))
            }
            if (popularProducts.isNotEmpty()) {
                HomeProductRow(products = popularProducts, title = "Popular Products", onClick)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomeContentPrev() {
    ExpressShopTheme {
        HomeContent(
            featured = homeUiState.featured,
            popularProducts = homeUiState.popularProducts,
            categories = homeUiState.categories,
            loadingState = false,
            errorState = null,
            onClick = { }
        )
    }
}

// write val for  preview HomeContent
val homeUiState = HomeScreenUiState(
    featured = listOf(
        Product(
            id = 1,
            title = "Product 1",
            price = 100.0,
            image = "https://picsum.photos/200/300",
            categoryId = 1,
            description = "Product 1 description"
        )),
    popularProducts = listOf(
        Product(
            id = 2,
            title = "Product 2",
            price = 200.0,
            image = "https://picsum.photos/200/300",
            categoryId = 2,
            description = "Product 2 description"
        )),
    categories = listOf("category 1", "category 2"),
    isLoading = false
)
