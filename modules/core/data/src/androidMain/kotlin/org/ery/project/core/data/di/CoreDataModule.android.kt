package org.ery.project.core.data.di

import io.ktor.client.engine.okhttp.OkHttp
import org.ery.project.core.data.network.HttpClientFactory
import org.koin.dsl.module

actual val platformCoreDataModule = module {
    single { HttpClientFactory(OkHttp.create()) }
}