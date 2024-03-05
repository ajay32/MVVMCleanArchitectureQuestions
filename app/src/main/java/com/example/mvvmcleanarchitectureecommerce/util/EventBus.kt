package com.example.mvvmcleanarchitectureecommerce.util

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow


// we are creating bus outside of our store so that other features can also use it
// we are making in singelton
object EventBus {
    private val _events = Channel<Any> {  }
    val events = _events.receiveAsFlow()

    // its a coroutnes flow fun so making it suspend
    suspend fun sendEvent(event: Any) {
        _events.send(event)
    }
}

sealed interface Event {
    data class Toast(var message: String) : Event
}