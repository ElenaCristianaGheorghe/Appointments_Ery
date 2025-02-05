package org.ery.project.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.ery.project.appointments_client.api.service.ClientServiceApi
import org.ery.project.appointments_client.impl.service.AppointmentsServiceImpl
import org.ery.project.appointments_client.impl.service.ClientServiceImpl
import org.ery.project.appointments_client.impl.service.EmployeeServiceImpl
import org.ery.project.appointments_client.impl.service.FacilityBookedServiceImpl
import org.ery.project.appointments_client.impl.service.FacilityServiceImpl
import service.AppointmentServiceApi
import service.EmployeeServiceApi
import service.FacilityServiceApi

expect val platformModule: Module

val sharedModule = module {
    singleOf(::AppointmentsServiceImpl).bind<AppointmentServiceApi>()
    singleOf(::ClientServiceImpl).bind<ClientServiceApi>()
    singleOf(::EmployeeServiceImpl).bind<EmployeeServiceApi>()
    singleOf(::FacilityBookedServiceImpl).bind<FacilityBookedServiceImpl>()
    singleOf(::FacilityServiceImpl).bind<FacilityServiceApi>()
}
