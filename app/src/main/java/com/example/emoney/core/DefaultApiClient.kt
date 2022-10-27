package com.example.emoney.core

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object DefaultApiClient {
    private const val BASE_URL = "https://api.apilayer.com/fixer/"
    private const val API_KEY = ""

    private fun buildOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(authInterceptor())
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder().client(buildOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    private fun authInterceptor() = Interceptor{
            chain ->
        val originalRequest = chain.request()
        val newRequest = originalRequest
            .newBuilder()
            .addHeader("apikey", API_KEY)
            .build()
        return@Interceptor chain.proceed(newRequest)
    }

    @Volatile
    private var INSTANCE: Retrofit? = null

    fun init() {
        INSTANCE = buildRetrofit()
    }

    @Synchronized
    fun getInstance(): Retrofit {
        return synchronized(this) {
            INSTANCE
                ?: throw IllegalArgumentException("You need to initialize ApiClient first in the application class")
        }
    }
}