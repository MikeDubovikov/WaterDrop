package com.example.waterdrop.di

import androidx.lifecycle.ViewModel
import com.example.waterdrop.presentation.home.HomeViewModel
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