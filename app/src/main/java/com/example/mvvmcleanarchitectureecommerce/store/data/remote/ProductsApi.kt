package com.example.mvvmcleanarchitectureecommerce.store.data.remote

import com.example.mvvmcleanarchitectureecommerce.store.domain.model.Product
import retrofit2.http.GET

// we need to hit products api to get the product data https://fakestoreapi.com/products
// data layer is all about implementations then why we are using interface here .. because
// retrofit ask us to impment the interface .. so it is upon the network lib how they want us to use

interface ProductsApi {
    @GET("products")
    suspend fun getProudcts() : List<Product>
}