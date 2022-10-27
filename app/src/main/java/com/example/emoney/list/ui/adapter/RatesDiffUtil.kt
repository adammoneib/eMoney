package com.example.emoney.list.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.emoney.list.domain.CurrencyRates

object RatesDiffUtil: DiffUtil.ItemCallback<CurrencyRates>() {
    override fun areItemsTheSame(oldItem: CurrencyRates, newItem: CurrencyRates): Boolean {
        return oldItem.rate == newItem.rate
    }

    override fun areContentsTheSame(oldItem: CurrencyRates, newItem: CurrencyRates): Boolean {
        return oldItem.rate == newItem.rate &&
                oldItem.currencyName == newItem.currencyName
    }
}