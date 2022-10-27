package com.example.emoney.list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emoney.list.domain.GetRatesUseCase
import kotlinx.coroutines.launch


class MainViewModel(
    private val useCase: GetRatesUseCase
): ViewModel() {

    companion object {
        private const val targetCurrencies = "GBP,USD,EGP,SAR,AED"
        private const val baseCurrency = "EUR"
    }

    private val ratesLiveData = MutableLiveData<RatesViewState>()
            val ratesViewState: LiveData<RatesViewState>
            get() = ratesLiveData

    fun getRates() {
        ratesLiveData.value = RatesViewState.Loading
        viewModelScope.launch {
            try {
                val response = useCase.ratesRepo.getRates(
                    targetCurrencyList = targetCurrencies,
                    baseCurrency = baseCurrency
                )
                ratesLiveData.value = RatesViewState.Success(response)
            } catch(throwable: Throwable) {
                ratesLiveData.value = RatesViewState.Error
            }
        }
    }
}