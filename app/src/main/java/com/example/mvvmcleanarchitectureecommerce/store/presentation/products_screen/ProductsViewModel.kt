package com.example.mvvmcleanarchitectureecommerce.store.presentation.products_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcleanarchitectureecommerce.store.domain.repository.ProductsRepository
import com.example.mvvmcleanarchitectureecommerce.store.presentation.util.sendEvent
import com.example.mvvmcleanarchitectureecommerce.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

// here to connect to Repository to ask for api data we will take product repository in constructor
// to get the ProductsRepository object we injected the constructor
@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepository : ProductsRepository
) : ViewModel() {

    // get states we have for our UI
    val _state = MutableStateFlow(ProductsViewState()) // state is changable
    val state = _state.asStateFlow() // taking imutable state to pass


    init { // my call is going from viewModel
        getProducts() // if want to get products as viewModel loads
    }



    // now we need to get products from repository
    fun getProducts() {
        viewModelScope.launch { // starting hitting the api
            _state.update {
                it.copy(isLoading = true)
            }
            productsRepository.getProducts()
                .onLeft { error ->
                _state.update { it.copy(error = error.error.message) }
                    sendEvent(Event.Toast(error.error.message))
            }.onRight {products ->
                _state.update { it.copy(products = products) }
            }

            _state.update { it.copy(isLoading = false) }
        }
    }
}