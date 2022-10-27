package com.example.emoney.list.domain

data class Rates(
    val currencyRates: List<CurrencyRates>,
    val timestamp: Long
)
