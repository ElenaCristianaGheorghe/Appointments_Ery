package org.ery.project

import android.app.Application
import org.ery.project.di.initKoin
import org.koin.android.ext.koin.androidContext

class EryApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@EryApplication)
        }
    }
}