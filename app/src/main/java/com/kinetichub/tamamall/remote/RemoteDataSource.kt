package com.kinetichub.tamamall.remote

import com.kinetichub.tamamall.models.BaseResponseModel
import com.kinetichub.tamamall.repository.ApiServices
import com.kinetichub.tamamall.repository.Resource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiServiceGenerator: ApiServiceGenerator) {

    private val service = apiServiceGenerator.createService(ApiServices::class.java)

    suspend fun loginRequest(
        phone_no: String,
        password: String
    ): Resource<BaseResponseModel> {
        return apiServiceGenerator.handleResponse(apiServiceGenerator.processCall {
            service.login(phone_no, password)
        })
    }
}