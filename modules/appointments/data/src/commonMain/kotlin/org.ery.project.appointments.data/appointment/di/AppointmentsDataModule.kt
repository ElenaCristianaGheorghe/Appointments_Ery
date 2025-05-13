package org.ery.project.appointments.data.appointment.di

import org.ery.project.appointments.data.appointment.AppointmentRepositoryImpl
import org.ery.project.appointments.data.appointment.network.KtorAppointmentDataSource
import org.ery.project.core.domain.appointment.AppointmentRepository
import org.ery.project.core.domain.appointment.RemoteAppointmentDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val appointmentsDataModule = module {
    single { AppointmentRepositoryImpl(get(), get(), get(named("applicationScope"))) }.bind<AppointmentRepository>()
    singleOf(::KtorAppointmentDataSource).bind<RemoteAppointmentDataSource>()
}