package com.example.emoney.list.data

import com.example.emoney.list.domain.Rates
import com.example.emoney.list.domain.RatesRepo

class RatesRemoteRepo(
    private val remote: ConverterRemoteDataSource,
    private val mapper: RatesMapper
): RatesRepo {

    override suspend fun getRates(
        targetCurrencyList: String,
        baseCurrency: String
    ): Rates {
        val response = remote.getRates(
            targetCurrencyList,
            baseCurrency
        )
        return if (response.isSuccessful && response.body() != null) {
            mapper.map(response.body()!!)
        } else
            throw Throwable("Body Empty")
    }
}