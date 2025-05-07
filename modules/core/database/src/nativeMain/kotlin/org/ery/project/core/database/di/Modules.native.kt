package org.ery.project.core.database.di

import org.ery.project.core.database.EryDatabase.Companion.getRoomDatabase
import org.ery.project.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformDatabaseModule: Module = module {
    single { getRoomDatabase(getDatabaseBuilder()) }
}