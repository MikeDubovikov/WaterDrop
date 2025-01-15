package com.mdubovikov.waterdrop.di

import com.mdubovikov.waterdrop.presentation.MainActivity
import com.mdubovikov.waterdrop.presentation.home.HomeFragment
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: HomeFragment)

    @Component.Factory
    interface Factory {

        fun create(): ApplicationComponent
    }
}