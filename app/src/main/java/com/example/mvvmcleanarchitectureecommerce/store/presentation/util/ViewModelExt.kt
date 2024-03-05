package com.example.mvvmcleanarchitectureecommerce.store.presentation.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcleanarchitectureecommerce.util.EventBus
import kotlinx.coroutines.launch

// we are creating this extension fun of ViewModel so that from viewModel we can call this method to send event
fun ViewModel.sendEvent(event: Any) {
    viewModelScope.launch {
        EventBus.sendEvent(event)
    }
}