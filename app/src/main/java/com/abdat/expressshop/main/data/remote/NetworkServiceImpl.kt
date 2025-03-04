package com.abdat.expressshop.main.data.remote

import com.abdat.expressshop.core.data.networking.HttpClientFactory
import com.abdat.expressshop.core.data.networking.constructUrl
import com.abdat.expressshop.core.data.networking.safeCall
import com.abdat.expressshop.core.domain.util.NetworkError
import com.abdat.expressshop.core.domain.util.Result
import com.abdat.expressshop.core.domain.util.map
import com.abdat.expressshop.main.data.dto.response.CategoriesListResponse
import com.abdat.expressshop.main.data.dto.response.ProductListResponse
import com.abdat.expressshop.main.domain.model.response.CartModel
import com.abdat.expressshop.main.domain.model.response.CategoriesListModel
import com.abdat.expressshop.main.domain.model.response.ProductListModel
import com.abdat.expressshop.main.domain.remote.NetworkService
import io.ktor.client.*
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking

class NetworkServiceImpl(private val client: HttpClient) : NetworkService {
    override suspend fun getProducts(category: Int? ): Result<NetworkError, ProductListModel> {
        return safeCall<ProductListResponse> {
            client.get(
                urlString = constructUrl("/products/category/$category")
            )
        }.map { response ->
            response.toProductList()
        }
    }
    override suspend fun getCategories(): Result<NetworkError, CategoriesListModel> {
       return safeCall<CategoriesListResponse> {
              client.get(
                urlString = constructUrl("/categories")
              )
         }.map { response ->
              response.toCategoriesList()
       }
    }

    override suspend fun getCart(): Result<NetworkError, CartModel> {
        TODO("Not yet implemented")
    }

}

// Test code
fun main() = runBlocking {
    // create a new instance of NetworkServiceImpl
    val networkService = NetworkServiceImpl(HttpClientFactory.create(CIO.create()))
    // call the getProducts function
    val products  = networkService.getCategories()
    // print the result
    when (products) {
        is Result.Success -> {
            products.data.categories.forEach {
                println(it.title)
            }
        }
        is Result.Error -> {
            println("Error: ${products.error}")
        }
    }

}



