package com.kinetichub.tamamall.models.login

import com.kinetichub.tamamall.models.BaseResponseModel

data class LoginServerResponse(
    override val status: String,
    override val message: String,
    val data: LoginData
) : BaseResponseModel(status, message)

data class LoginData(
    val token: Token,
  //  val user: User
)

data class Token(
    val tokenType: String,
    val accessToken: String,
    val refreshToken: String?,
    val expiresIn: Int
)
