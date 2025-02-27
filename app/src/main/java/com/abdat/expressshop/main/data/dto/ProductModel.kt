package com.abdat.expressshop.main.data.dto

import com.abdat.expressshop.main.domain.model.response.Product
import kotlinx.serialization.Serializable

@Serializable
data class ProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val categoryId: Int,
) {
    fun toProduct() = Product(
        id = id,
        title = title,
        price = price,
        categoryId = categoryId,
        description = description,
        image = image
    )
}