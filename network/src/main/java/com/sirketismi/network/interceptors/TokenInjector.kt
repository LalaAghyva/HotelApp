package com.sirketismi.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenInjector @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val authRequest = originalRequest.newBuilder().method(originalRequest.method, originalRequest.body)

        authRequest.addHeader("AUTHORIZATION", "Bearer {token}")

        return chain.proceed(authRequest.build())
    }

}