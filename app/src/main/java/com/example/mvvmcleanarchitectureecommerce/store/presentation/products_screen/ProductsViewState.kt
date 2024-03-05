package com.example.mvvmcleanarchitectureecommerce.store.presentation.products_screen

import com.example.mvvmcleanarchitectureecommerce.store.domain.model.Product

//we have created data class to hold the states what UI is going to show loader is showing, data has come or error has come
// now pass this state to ProudctsContent .. based on this state we are going to show differnt content on the UI
data class ProductsViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)