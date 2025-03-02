package com.abdat.expressshop.main.presentation.ui.feature.home

import androidx.compose.runtime.Immutable
import com.abdat.expressshop.main.domain.model.response.Product


@Immutable
data class HomeScreenUiState(
    val isLoading: Boolean = false,
    val featured: List<Product> = emptyList(),
    val popularProducts: List<Product> = emptyList(),
    val categories: List<String> = emptyList(),
)
