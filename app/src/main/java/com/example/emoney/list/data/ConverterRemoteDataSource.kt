package com.example.emoney.list.data

import com.example.emoney.list.data.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ConverterRemoteDataSource {

    @GET("latest")
    suspend fun getRates(
        @Query("symbols") currencies: String,
        @Query("base") baseCurrency: String
    ): Response<ApiResponse>
}