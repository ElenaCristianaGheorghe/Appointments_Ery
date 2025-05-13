package org.ery.project.di

import org.ery.project.appointments.data.appointment.di.appointmentsDataModule
import org.ery.project.core.data.di.platformCoreDataModule
import org.ery.project.core.database.di.databaseModule
import org.ery.project.core.database.di.platformDatabaseModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            sharedMainModule,
            platformMainModule,
            databaseModule,
            platformDatabaseModule,
            platformCoreDataModule,
            appointmentsDataModule
        )
    }
}