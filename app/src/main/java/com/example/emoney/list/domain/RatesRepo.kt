package com.example.emoney.list.domain

interface RatesRepo {

    suspend fun getRates(
        targetCurrencyList: String,
        baseCurrency: String
    ): Rates
}