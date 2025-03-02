package com.abdat.expressshop.main.domain.use_case

import com.abdat.expressshop.main.domain.repository.ProductRepo

class GetProduct(private val repo: ProductRepo) {
    suspend operator fun invoke(category: Int) = repo.getProducts(category)
}