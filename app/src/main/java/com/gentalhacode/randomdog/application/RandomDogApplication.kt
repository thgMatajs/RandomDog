package com.gentalhacode.randomdog.application

import android.app.Application
import com.gentalhacode.randomdog.data.di.dataModule
import com.gentalhacode.randomdog.domain.di.domainModule
import com.gentalhacode.randomdog.remote.di.remoteModule
import com.gentalhacode.randomdog.view.di.viewModeule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
class RandomDogApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            loadKoinModules(listOf(
                viewModeule,
                domainModule,
                dataModule,
                remoteModule
            ))
        }
    }
}