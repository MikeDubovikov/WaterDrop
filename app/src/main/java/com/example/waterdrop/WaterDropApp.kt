package com.example.waterdrop

import android.app.Application
import com.example.waterdrop.di.ApplicationComponent
import com.example.waterdrop.di.DaggerApplicationComponent

class WaterDropApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create()
    }
}