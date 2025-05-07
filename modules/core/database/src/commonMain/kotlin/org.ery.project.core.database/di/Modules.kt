package org.ery.project.core.database.di

import org.ery.project.core.database.EryDatabase
import org.ery.project.core.database.dao.AppointmentDao
import org.ery.project.core.database.dao.ClientDao
import org.ery.project.core.database.dao.EmployeeDao
import org.ery.project.core.database.dao.FacilityBookedDao
import org.ery.project.core.database.dao.FacilityDao
import org.ery.project.core.database.datasource.RoomLocalAppointmentsDataSource
import org.ery.project.core.database.datasource.RoomLocalClientDataSource
import org.ery.project.core.database.datasource.RoomLocalEmployeeDataSource
import org.ery.project.core.database.datasource.RoomLocalFacilityDataSource
import org.ery.project.core.domain.appointment.LocalAppointmentDataSource
import org.ery.project.core.domain.client.LocalClientDataSource
import org.ery.project.core.domain.employee.LocalEmployeeDataStore
import org.ery.project.core.domain.facility.LocalFacilityDataSource
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformDatabaseModule: Module

val databaseModule = module {
    single<ClientDao> { get<EryDatabase>().clientDao() }
    single<AppointmentDao> { get<EryDatabase>().appointmentDao() }
    single<EmployeeDao> { get<EryDatabase>().employeeDao() }
    single<FacilityDao> { get<EryDatabase>().facilityDao() }
    single<FacilityBookedDao> { get<EryDatabase>().facilityBookedDao() }
    singleOf(::RoomLocalEmployeeDataSource).bind<LocalEmployeeDataStore>()
    singleOf(::RoomLocalAppointmentsDataSource).bind<LocalAppointmentDataSource>()
    singleOf(::RoomLocalClientDataSource).bind<LocalClientDataSource>()
    singleOf(::RoomLocalFacilityDataSource).bind<LocalFacilityDataSource>()
}