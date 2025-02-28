package org.ery.project.di

import org.ery.project.EryDatabase
import org.ery.project.dao.AppointmentDao
import org.ery.project.dao.ClientDao
import org.ery.project.dao.EmployeeDao
import org.ery.project.dao.FacilityBookedDao
import org.ery.project.dao.FacilityDao
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformRepoModule: Module

val repoModule = module {
    single<ClientDao> { get<EryDatabase>().clientDao() }
    single<AppointmentDao> { get<EryDatabase>().appointmentDao() }
    single<EmployeeDao> { get<EryDatabase>().employeeDao() }
    single<FacilityDao> { get<EryDatabase>().facilityDao() }
    single<FacilityBookedDao> { get<EryDatabase>().facilityBookedDao() }
}