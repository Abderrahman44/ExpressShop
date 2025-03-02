package com.abdat.expressshop.main.presentation.model

import android.os.Parcelable
import com.abdat.expressshop.main.domain.model.response.Product
import kotlinx.serialization.Serializable


data class UiProductModel(
    val categoryId: Int,
    val image: String,
    val id: Int,
    val description: String,
    val title: String,
    val price: Double,
) {
    companion object {
        fun fromProduct(product: Product
        ) = UiProductModel(
            categoryId = product.categoryId,
            image = product.image,
            id = product.id,
            description = product.description,
            title = product.title,
            price = product.price
        )
    }
}
