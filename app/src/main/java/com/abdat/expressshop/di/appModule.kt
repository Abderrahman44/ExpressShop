package com.abdat.expressshop.di

import androidx.compose.animation.fadeOut
import com.abdat.expressshop.core.data.networking.HttpClientFactory
import com.abdat.expressshop.main.data.remote.NetworkServiceImpl
import com.abdat.expressshop.main.data.repository.CategoryRepoImpl
import com.abdat.expressshop.main.data.repository.ProductRepoImp
import com.abdat.expressshop.main.domain.remote.NetworkService
import com.abdat.expressshop.main.domain.repository.CategoryRepo
import com.abdat.expressshop.main.domain.repository.ProductRepo
import com.abdat.expressshop.main.domain.use_case.GetCategories
import com.abdat.expressshop.main.domain.use_case.GetProduct
import com.abdat.expressshop.main.presentation.ui.feature.home.HomeVM
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    single<NetworkService> { NetworkServiceImpl(get()) }
    single<ProductRepo> { ProductRepoImp(get()) }
    single<CategoryRepo> { CategoryRepoImpl(get()) }

    factory { GetProduct(get()) }
    factory { GetCategories(get()) }

    viewModel { HomeVM(get(),get()) }

}