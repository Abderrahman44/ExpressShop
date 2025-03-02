package com.abdat.expressshop.main.presentation.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdat.expressshop.core.domain.util.Result
import com.abdat.expressshop.core.domain.util.onSuccess
import com.abdat.expressshop.main.domain.use_case.GetCategories
import com.abdat.expressshop.main.domain.use_case.GetProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeVM(
    private val getProducts: GetProduct,
    private val getCategories: GetCategories,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState
        .onStart { getHomeProducts() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            HomeScreenUiState()
        )


    private fun getHomeProducts() {
        viewModelScope.launch {
            getProducts(1).onSuccess {
                _uiState.value = _uiState.value.copy(
                    featured = it.products
                )
            }
            getProducts(2).onSuccess {
                _uiState.value = _uiState.value.copy(
                    popularProducts = it.products
                )
            }
            getCategories().onSuccess {
                _uiState.value = _uiState.value.copy(
                    categories = it.categories.map { it.title }
                )
            }

        }
    }


}
