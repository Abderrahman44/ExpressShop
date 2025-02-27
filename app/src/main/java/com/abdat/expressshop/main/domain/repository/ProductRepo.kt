package com.abdat.expressshop.main.domain.repository

import com.abdat.expressshop.core.domain.util.NetworkError
import com.abdat.expressshop.core.domain.util.Result
import com.abdat.expressshop.main.domain.model.response.ProductListModel


interface ProductRepo {
    suspend fun getProducts(category: Int): Result<NetworkError, ProductListModel>
}