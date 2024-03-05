package com.example.mvvmcleanarchitectureecommerce.store.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mvvmcleanarchitectureecommerce.store.presentation.products_screen.components.ProductCard
import com.example.mvvmcleanarchitectureecommerce.store.presentation.util.components.LoadingDialog
import com.example.mvvmcleanarchitectureecommerce.store.presentation.util.components.MyTopAppBar


// it will have ViewModel, Navcontroller or anything.. we seperated this from its Content
// lets make it internal so it will only be used in this module
@Composable
internal fun ProductsScreen() { // we need viewModel object to get view state all the time. so view and ask view model for data
       val viewModel: ProductsViewModel = hiltViewModel()
       // we need to collect state to receive it
       val state by viewModel.state.collectAsStateWithLifecycle(initialValue = ProductsViewState())
       ProductsContent(state = state)
       
}

// to make it testable I am going to seperate its content from Screen itself
// it will only hold state no vieModel (UI things)
// here we are goin to receive the state on bases of that we going to show differnt UI to user
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsContent(state: ProductsViewState) {
       LoadingDialog(isLoading = state.isLoading) // when state is true for isLoading it will show
       LoadingDialog(isLoading = state.isLoading)
       Scaffold(
              modifier = Modifier.fillMaxSize(),
              topBar = { MyTopAppBar(text = "Products") }
       ) {
              LazyVerticalStaggeredGrid(
                     modifier = Modifier.padding(top = it.calculateTopPadding()),
                     columns = StaggeredGridCells.Fixed(2),
                     horizontalArrangement = Arrangement.spacedBy(10.dp),
                     verticalItemSpacing = 10.dp
              ) {
                     items(state.products) { product ->
                            ProductCard(product = product)
                     }
              }
       }
}
