package org.ery.project.di

import org.ery.project.EryDatabase.Companion.getRoomDatabase
import org.ery.project.getDatabaseBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformRepoModule: Module = module {
    single { getRoomDatabase(getDatabaseBuilder(androidContext())) }
}