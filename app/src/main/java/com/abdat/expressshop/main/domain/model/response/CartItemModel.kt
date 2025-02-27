package com.abdat.expressshop.main.domain.model.response

data class  CartItemModel(
    val id: Int,
    val productId: Int,
    val price: Double,
    val imageUrl: String?,
    val quantity: Int,
    val productName: String
)
