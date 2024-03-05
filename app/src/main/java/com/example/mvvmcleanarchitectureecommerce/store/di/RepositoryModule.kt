package com.example.mvvmcleanarchitectureecommerce.store.di

import com.example.mvvmcleanarchitectureecommerce.store.data.repository.ProductsRepositoryImpl
import com.example.mvvmcleanarchitectureecommerce.store.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsProductRepository(impl: ProductsRepositoryImpl) : ProductsRepository


}