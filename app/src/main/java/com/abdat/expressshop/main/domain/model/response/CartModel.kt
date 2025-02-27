package com.abdat.expressshop.main.domain.model.response


data class CartModel(
    val msg: String,
    val data: List<CartItemModel>,
)
