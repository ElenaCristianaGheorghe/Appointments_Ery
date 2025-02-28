package org.ery.project.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            sharedMainModule,
            platformMainModule,
            repoModule,
            platformRepoModule
        )
    }
}