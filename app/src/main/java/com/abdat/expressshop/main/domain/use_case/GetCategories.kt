package com.abdat.expressshop.main.domain.use_case

import com.abdat.expressshop.main.domain.repository.CategoryRepo

class GetCategories(private val repo: CategoryRepo) {
    suspend operator fun invoke() = repo.getCategories()
}