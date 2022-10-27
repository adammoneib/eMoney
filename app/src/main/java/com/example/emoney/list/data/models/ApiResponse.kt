package com.example.emoney.list.data.models

data class ApiResponse(
    val rates: CurrencyListRemote,
    val timestamp: Long
)
