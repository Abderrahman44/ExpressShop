package com.abdat.expressshop.main.data.repository

import com.abdat.expressshop.main.domain.remote.NetworkService
import com.abdat.expressshop.main.domain.repository.ProductRepo


class ProductRepoImp(private val networkService: NetworkService ): ProductRepo {
    override suspend fun getProducts(category: Int)
    = networkService.getProducts(category)
}