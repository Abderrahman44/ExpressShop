package com.abdat.expressshop.main.data.dto.response

import com.abdat.expressshop.main.domain.model.response.CartItemModel
import kotlinx.serialization.Serializable

@Serializable
data class CartItem(
    val id: Int,
    val productId: Int,
    val productName: String,
    val price: Double,
    val quantity: Int,
    val imageUrl: String?,
) {
    fun toCartItemModel() = CartItemModel(
        id = id,
        productId = productId,
        price = price,
        imageUrl = imageUrl,
        quantity = quantity,
        productName = productName
    )
}