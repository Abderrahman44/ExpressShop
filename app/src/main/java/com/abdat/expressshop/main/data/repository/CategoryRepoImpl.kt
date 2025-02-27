package com.abdat.expressshop.main.data.repository


import com.abdat.expressshop.main.domain.remote.NetworkService
import com.abdat.expressshop.main.domain.repository.CategoryRepo

class CategoryRepoImpl(val networkService: NetworkService): CategoryRepo {
    override suspend fun getCategories()
    = networkService.getCategories()

}