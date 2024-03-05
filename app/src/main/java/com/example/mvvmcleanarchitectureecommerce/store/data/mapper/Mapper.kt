package com.example.mvvmcleanarchitectureecommerce.store.data.mapper

import com.example.mvvmcleanarchitectureecommerce.store.domain.model.ApiError
import com.example.mvvmcleanarchitectureecommerce.store.domain.model.NetworkError
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException
import java.io.IOException

// we crated extension fun for Throwable class so when this class will through any exception to us we will convert it to Network error
// it can through many type of exceptions

fun Throwable.toNetworkError() : NetworkError {



    val error = when(this) {
        is IOException -> ApiError.NetworkError
        is HttpException-> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}
