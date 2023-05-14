package com.kinetichub.tamamall.di

import android.content.Context
import com.kinetichub.tamamall.TaMaMallApplication.Companion.context
import com.kinetichub.tamamall.utilities.*
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class Interceptor : Interceptor {
    private val contentType = "Content-Type"
    private val contentTypeValue = "application/json"
    private lateinit var language: String
    override fun intercept(chain: Interceptor.Chain): Response {
        language = if (context.getSharedPreferences(DATA_STORE, Context.MODE_PRIVATE)
                .getString(
                    API_CALL_LANGUAGE, null
                ) == MM_LANG
        ) {
            "mm"
        } else EN_LANG
        val original = chain.request()
        val builder = original.newBuilder()
        builder.header(contentType, contentTypeValue)
        builder.header("Accept-Language", language)
        builder.method(original.method, original.body)
        if (getToken() != null) {
            setAuthHeader(builder, getToken())
        }
        return chain.proceed(builder.build())
    }

    private fun setAuthHeader(builder: Request.Builder, token: String?) {
        builder.header("Authorization", String.format("Bearer %s", token))
    }

    private fun getToken() =
        context.getSharedPreferences(DATA_STORE, Context.MODE_PRIVATE)
            .getString(
                TOKEN, null
            )
}