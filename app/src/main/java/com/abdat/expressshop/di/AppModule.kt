package com.abdat.expressshop.di

import com.abdat.expressshop.core.data.networking.HttpClientFactory
import com.abdat.expressshop.main.data.remote.NetworkServiceImpl
import com.abdat.expressshop.main.domain.remote.NetworkService
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module

val AppModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    single<NetworkService> { NetworkServiceImpl(get()) }

}