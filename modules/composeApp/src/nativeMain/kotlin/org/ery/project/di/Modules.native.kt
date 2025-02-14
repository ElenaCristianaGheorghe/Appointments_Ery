package org.ery.project.di

import io.ktor.client.engine.darwin.Darwin
import org.ery.project.AppointmentsHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single { AppointmentsHttpClient(Darwin.create()) }
}