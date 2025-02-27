package com.abdat.expressshop.main.data.dto.response

import com.abdat.expressshop.main.data.dto.ProductModel
import com.abdat.expressshop.main.domain.model.response.ProductListModel
import kotlinx.serialization.Serializable

@Serializable
data class ProductListResponse(
    val data: List<ProductModel>,
    val msg: String
) {
    fun toProductList() = ProductListModel(
        products = data.map { it.toProduct() },
        msg = msg
    )
}