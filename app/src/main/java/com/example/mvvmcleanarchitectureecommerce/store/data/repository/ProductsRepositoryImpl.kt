package com.example.mvvmcleanarchitectureecommerce.store.data.repository

import arrow.core.Either
import com.example.mvvmcleanarchitectureecommerce.store.data.mapper.toNetworkError
import com.example.mvvmcleanarchitectureecommerce.store.data.remote.ProductsApi
import com.example.mvvmcleanarchitectureecommerce.store.domain.model.NetworkError
import com.example.mvvmcleanarchitectureecommerce.store.domain.model.Product
import com.example.mvvmcleanarchitectureecommerce.store.domain.repository.ProductsRepository
import javax.inject.Inject


// this class will implement domain layer Products Repository
// Repository wants to get products from the products API ..so in this implemenation we will pass productsAPi through constructor
// create constructor and pass it to the class
// so when getting data from api to catch exception we are not going to use try and catch anymore
// reason -> in large codebase u will be confused in which layer u going to use try catch in repository or in vieModel
// u wanaa if the fun is really going to throw exception fun1 depends on fun2 on func3.. so in all fun u take care of exception
// issue with corotins cancellation exception ..we want it to perform different than just catching exception
// so we are going to use Either

//we have a type mismatch
//
//Type mismatch.
//Required:
//Either<NetworkError, List<Product>>
//Found:
//Either<Throwable, List<Product>>
// we wil require mapper function  to map Throwable to Network Error


class ProductsRepositoryImpl @Inject constructor( // injecting ProductsApi
    private val productsApi: ProductsApi
): ProductsRepository {
    // so from api we could get error or list of products
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
       return  Either.catch { // getting proudcts might through exception
            productsApi.getProudcts()
        }.mapLeft { it.toNetworkError() }


    }
}