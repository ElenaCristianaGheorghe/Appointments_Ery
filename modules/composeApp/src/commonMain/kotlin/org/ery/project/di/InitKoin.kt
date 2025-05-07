package org.ery.project.di

import org.ery.project.core.database.di.databaseModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            sharedMainModule,
            platformMainModule,
            databaseModule
        )
    }
}