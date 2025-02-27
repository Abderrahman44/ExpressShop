package com.abdat.expressshop.main.domain.remote

import com.abdat.expressshop.core.domain.util.NetworkError
import com.abdat.expressshop.core.domain.util.Result
import com.abdat.expressshop.main.domain.model.response.CartModel
import com.abdat.expressshop.main.domain.model.response.CategoriesListModel
import com.abdat.expressshop.main.domain.model.response.ProductListModel


interface NetworkService {
    suspend fun getProducts(category: Int?): Result<NetworkError, ProductListModel>
    suspend fun getCategories(): Result<NetworkError, CategoriesListModel>
    suspend fun getCart(): Result<NetworkError, CartModel>
}

