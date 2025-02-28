package org.ery.project.di

import org.ery.project.service.AppointmentServiceApi
import org.ery.project.service.AppointmentsServiceImpl
import org.ery.project.service.ClientServiceApi
import org.ery.project.service.ClientServiceImpl
import org.ery.project.service.EmployeeServiceApi
import org.ery.project.service.EmployeeServiceImpl
import org.ery.project.service.FacilityBookedServiceImpl
import org.ery.project.service.FacilityServiceApi
import org.ery.project.service.FacilityServiceImpl
import org.ery.project.viewmodels.CalendarViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    singleOf(::AppointmentsServiceImpl).bind<AppointmentServiceApi>()
    singleOf(::ClientServiceImpl).bind<ClientServiceApi>()
    singleOf(::EmployeeServiceImpl).bind<EmployeeServiceApi>()
    singleOf(::FacilityBookedServiceImpl).bind<FacilityBookedServiceImpl>()
    singleOf(::FacilityServiceImpl).bind<FacilityServiceApi>()

    //VMs
    viewModel { CalendarViewModel() }
}
