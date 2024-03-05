package com.example.mvvmcleanarchitectureecommerce.store.di

import com.example.mvvmcleanarchitectureecommerce.store.data.remote.ProductsApi
import com.example.mvvmcleanarchitectureecommerce.util.Constant.BASES_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


// di package wont belong to any feature so we created outside

@InstallIn(SingletonComponent::class)
@Module
object AppModule { // it will give application level object


    @Singleton
    @Provides
     fun provideProductsApi() : ProductsApi {  // Retrofit object
        return Retrofit.Builder()
            .baseUrl(BASES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsApi::class.java)
    }
}