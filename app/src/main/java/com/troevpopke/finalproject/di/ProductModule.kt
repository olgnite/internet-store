package com.troevpopke.finalproject.di

import com.troevpopke.feature.home.data.ProductRepository
import com.troevpopke.feature.home.data.ProductRepositoryImpl
import com.troevpopke.feature.home.network.ProductApiService
import com.troevpopke.feature_details.data.ProductDetailsRepository
import com.troevpopke.feature_details.data.ProductDetailsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductModule {

    @Provides
    @Singleton
    fun provideProductApiService(retrofit: Retrofit): ProductApiService {
        return retrofit.create()
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

    @Binds
    fun bindProductDetails(impl: ProductDetailsRepositoryImpl): ProductDetailsRepository
}