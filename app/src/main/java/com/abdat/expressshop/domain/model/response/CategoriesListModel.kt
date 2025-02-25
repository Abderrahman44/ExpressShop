package com.abdat.expressshop.domain.model.response



data class CategoriesListModel(
    val categories: List<Category>,
    val msg: String
)