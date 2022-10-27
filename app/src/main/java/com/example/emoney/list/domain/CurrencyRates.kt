package com.example.emoney.list.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyRates(
    val currencyName: String,
    val rate: Double
): Parcelable
