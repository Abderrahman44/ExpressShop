package com.abdat.expressshop.data.dto.response


import com.abdat.expressshop.domain.model.response.Category
import kotlinx.serialization.Serializable

@Serializable
data class CategoryDataModel(
    val id: Int,
    val title: String,
    val image: String,
) {
    fun toCategory() = Category(
        id = id,
        image = image,
        title = title
    )
}
