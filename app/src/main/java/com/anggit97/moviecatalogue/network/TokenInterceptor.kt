package com.anggit97.moviecatalogue.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val apiKey: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url: HttpUrl
        val newRequest: Request

        url = request.url().newBuilder()
            .addEncodedQueryParameter("api_key", apiKey)
            .build()

        newRequest = request.newBuilder().url(url).header("Accept", "application/json").build()

        return chain.proceed(newRequest)
    }
}