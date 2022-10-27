package com.example.emoney.list.data

import com.example.emoney.list.data.models.ApiResponse
import com.example.emoney.list.domain.CurrencyRates
import com.example.emoney.list.domain.Rates

object RatesMapper {

    const val AED = "AED"
    const val EGP = "EGP"
    const val GBP = "GBP"
    const val SAR = "SAR"
    const val USD = "USD"

    fun map(response: ApiResponse): Rates {
        return Rates(
            listOf(
            CurrencyRates(AED, response.rates.AED),
            CurrencyRates(EGP, response.rates.EGP),
            CurrencyRates(GBP, response.rates.GBP),
            CurrencyRates(SAR, response.rates.SAR),
            CurrencyRates(USD, response.rates.USD),
        ), response.timestamp)
    }
}