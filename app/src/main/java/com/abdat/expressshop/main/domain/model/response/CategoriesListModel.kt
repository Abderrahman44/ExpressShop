package com.abdat.expressshop.main.domain.model.response



data class CategoriesListModel(
    val categories: List<Category>,
    val msg: String
)