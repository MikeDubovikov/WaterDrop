package com.mdubovikov.waterdrop

import android.app.Application
import com.mdubovikov.waterdrop.di.ApplicationComponent
import com.mdubovikov.waterdrop.di.DaggerApplicationComponent

class WaterDropApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create()
    }
}