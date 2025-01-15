package com.mdubovikov.waterdrop.di

import androidx.lifecycle.ViewModel
import com.mdubovikov.waterdrop.presentation.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    @Binds
    fun bindViewModel(impl: HomeViewModel): ViewModel
}