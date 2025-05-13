package org.ery.project.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module


expect val platformMainModule: Module

val sharedMainModule = module {
    single<CoroutineScope>(named("applicationScope")) {
        CoroutineScope(SupervisorJob())
    }
}
