package com.troevpopke.finalproject.di

import com.troevpopke.feature.home.data.ProductRepository
import com.troevpopke.feature.home.data.ProductRepositoryImpl
import com.troevpopke.feature.home.network.ProductApiService
import com.troevpopke.feature.home.network.ProductInstance
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductModule {

    @Provides
    @Singleton
    fun provideProductApiService(): ProductApiService {
        return ProductInstance.api
    }

    @Provides
    @Singleton
    fun coroutineScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + CoroutineName("SingletonScope"))
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface ProductsBindsModule {

    @Binds
    fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository
}