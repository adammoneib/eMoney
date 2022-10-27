package com.example.emoney.list.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRatesUseCase(
    val ratesRepo: RatesRepo
) {
    suspend operator fun  invoke(
        targetCurrencies: String,
        baseCurrency: String
    ): Rates {
        return withContext(Dispatchers.IO) {
            ratesRepo.getRates(
                targetCurrencies,
                baseCurrency
            )
        }
    }
}