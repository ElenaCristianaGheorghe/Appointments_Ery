package org.ery.project.di

import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.ery.project.appointments_client.impl.AppointmentsHttpClient

actual val platformModule: Module = module {
    single { AppointmentsHttpClient(Darwin.create()) }
}