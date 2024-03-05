package com.example.mvvmcleanarchitectureecommerce.store.domain.repository

import arrow.core.Either
import com.example.mvvmcleanarchitectureecommerce.store.domain.model.NetworkError
import com.example.mvvmcleanarchitectureecommerce.store.domain.model.Product

// This Repositry will get products from data layer (api) so that is why it is suspend fun for async
// it will return Either object to ViewModel
// Either will hold error data in left side, Products Data in right side.. so we need to make error data class for Network Errors
interface ProductsRepository {

    suspend fun getProducts() : Either<NetworkError, List<Product>>
}