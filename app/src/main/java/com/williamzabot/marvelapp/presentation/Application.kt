package com.williamzabot.marvelapp.presentation

import android.app.Application
import com.williamzabot.marvelapp.data.di.dataModule
import com.williamzabot.marvelapp.domain.di.domainModule
import com.williamzabot.marvelapp.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {

    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(
                domainModule,
                dataModule,
                presentationModule
            )
        }
    }
}