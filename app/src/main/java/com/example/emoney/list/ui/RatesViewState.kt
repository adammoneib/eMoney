package com.example.emoney.list.ui

import com.example.emoney.list.domain.Rates

sealed class RatesViewState {
    object Loading: RatesViewState()
    data class Success(val rates: Rates): RatesViewState()
    object Error: RatesViewState()
}