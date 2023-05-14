package com.kinetichub.tamamall.repository

import com.kinetichub.tamamall.models.login.LoginServerResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiServices {
    @FormUrlEncoded
    @POST("api/v1/users/login")
    suspend fun login(
        @Field("phoneNo") phoneNo: String,
        @Field("password") password: String
    ): Response<LoginServerResponse>
/*
    @POST("api/v1/users/register")
    suspend fun register(
        @Body registerRequestBody: RegisterRequestBody,
        @Query("key") key: String,
        @Query("otp") otp: String
    ): Response<RegisterServerResponse>*/
}