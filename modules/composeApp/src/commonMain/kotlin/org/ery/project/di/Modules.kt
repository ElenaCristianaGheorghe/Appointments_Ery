package org.ery.project.di

import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformMainModule: Module

val sharedMainModule = module {
}
