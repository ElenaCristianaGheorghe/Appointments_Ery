package org.ery.project.di

import org.ery.project.EryDatabase
import org.ery.project.dao.AppointmentDao
import org.ery.project.dao.ClientDao
import org.ery.project.dao.EmployeeDao
import org.ery.project.dao.FacilityBookedDao
import org.ery.project.dao.FacilityDao
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

expect val platformMainModule: Module

val sharedMainModule = module {
    singleOf(::AppointmentsServiceImpl).bind<AppointmentServiceApi>()
    singleOf(::ClientServiceImpl).bind<ClientServiceApi>()
    singleOf(::EmployeeServiceImpl).bind<EmployeeServiceApi>()
    singleOf(::FacilityBookedServiceImpl).bind<FacilityBookedServiceImpl>()
    singleOf(::FacilityServiceImpl).bind<FacilityServiceApi>()

    //VMs
    viewModel { CalendarViewModel() }

    single<ClientDao> { get<EryDatabase>().clientDao() }
    single<AppointmentDao> { get<EryDatabase>().appointmentDao() }
    single<EmployeeDao> { get<EryDatabase>().employeeDao() }
    single<FacilityDao> { get<EryDatabase>().facilityDao() }
    single<FacilityBookedDao> { get<EryDatabase>().facilityBookedDao() }
}
