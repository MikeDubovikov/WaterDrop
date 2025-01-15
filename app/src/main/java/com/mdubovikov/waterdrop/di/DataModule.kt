package com.mdubovikov.waterdrop.di

import com.mdubovikov.waterdrop.data.api.ApiFactory
import com.mdubovikov.waterdrop.data.repository.CatalogRepositoryImpl
import com.mdubovikov.waterdrop.domain.repository.CatalogRepository
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