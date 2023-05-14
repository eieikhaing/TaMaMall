package com.kinetichub.tamamall.remote

import com.kinetichub.tamamall.models.BaseResponseModel
import com.kinetichub.tamamall.repository.Resource
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiServiceGenerator @Inject
constructor(private val retrofit: Retrofit) {
    companion object {
        const val TOKEN_EXPIRED = 401
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }

    fun handleResponse(responseCall: Any?): Resource<BaseResponseModel> {
        return when (responseCall) {
            is BaseResponseModel -> {
                Resource.Success(data = responseCall)
            }
            else -> {
                Resource.DataError(errorMessage = responseCall as String)
            }
        }
    }

    suspend fun processCall(responseCall: suspend () -> Response<*>): Any? {
        /* if (!Network.isConnected(context)) {
             return context.getString(R.string.no_internet)
         }*/
        return try {
            val response = responseCall.invoke()
            when {
                response.isSuccessful -> {
                    response.body()
                }
                response.code() == TOKEN_EXPIRED -> {
                    /* DataModule.tokenExpired.postValue(true)
                     context.getString(R.string.refresh)*/
                }
                else -> {
                    // response.errorBody()?.byteStream()?.retrieveResponse()
                }
            }
        } catch (e: IOException) {
            // context.getString(R.string.network_error)
        }
    }


}