package org.ery.project.di

import org.koin.core.module.Module
import org.koin.dsl.module
import io.ktor.client.engine.okhttp.OkHttp
import org.ery.project.appointments_client.impl.AppointmentsHttpClient


actual val platformModule: Module = module {
    single { AppointmentsHttpClient(OkHttp.create()) }
}