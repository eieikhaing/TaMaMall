package com.kinetichub.tamamall.models

import com.google.gson.annotations.SerializedName

abstract class BaseResponseModel(
    @SerializedName("status")
    open val status:String,
    @SerializedName("message")
    open val message:String
)