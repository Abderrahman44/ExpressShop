package com.abdat.expressshop.domain.repository

import com.abdat.expressshop.core.domain.util.NetworkError
import com.abdat.expressshop.core.domain.util.Result
import com.abdat.expressshop.domain.model.response.CategoriesListModel


interface CategoryRepo {
    suspend fun getCategories(): Result<NetworkError,CategoriesListModel>
}