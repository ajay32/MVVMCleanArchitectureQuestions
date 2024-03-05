package com.example.mvvmcleanarchitectureecommerce.store.domain.model

// we can get several types of error from network so create enum for it
data class NetworkError(
    val error : ApiError,
    val t: Throwable? = null
)

// what it will get from api when api throws error -> a message passage in constructor
enum class ApiError(val message: String) {
    NetworkError("Network Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("Unknown Error")
}
