package com.abdat.expressshop.domain.model.response


data class CartModel(
    val msg: String,
    val data: List<CartItemModel>,
)
