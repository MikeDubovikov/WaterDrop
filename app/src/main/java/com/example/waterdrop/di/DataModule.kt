package com.example.waterdrop.di

import com.example.waterdrop.data.api.ApiFactory
import com.example.waterdrop.data.repository.CatalogRepositoryImpl
import com.example.waterdrop.domain.repository.CatalogRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindCatalogRepository(impl: CatalogRepositoryImpl): CatalogRepository

    companion object {

        @[ApplicationScope Provides]
        fun provideApiService() = ApiFactory.apiService
    }
}