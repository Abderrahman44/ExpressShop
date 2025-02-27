package com.abdat.expressshop.main.data.repository

import com.abdat.expressshop.core.domain.util.NetworkError
import com.abdat.expressshop.core.domain.util.Result
import com.abdat.expressshop.main.domain.model.response.CartModel
import com.abdat.expressshop.main.domain.remote.NetworkService
import com.abdat.expressshop.main.domain.repository.CartRepo


class CartRepoImpl(val networkService: NetworkService): CartRepo {
    override suspend fun getCart(): Result<NetworkError,CartModel> =  networkService.getCart()



}