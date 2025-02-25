package com.abdat.expressshop.data.dto.response

import com.abdat.expressshop.domain.model.response.CartModel
import kotlinx.serialization.Serializable

@Serializable
data class CartResponse(
    val data: List<CartItem>,
    val msg: String,
) {
    fun toCartModel() = CartModel(
        data = data.map { it.toCartItemModel() },
        msg = msg
    )
}