package com.gentalhacode.randomdog.remote.retrofit

import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * .:.:.:. Created by @thgMatajs on 25/03/20 .:.:.:.
 */
class RetrofitBuilder {
    inline operator fun <reified S> invoke(baseUrl: String): S {
        val httpClient = buildInterceptors()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(S::class.java)
    }

    fun buildInterceptors(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
        }.build()
    }
}
