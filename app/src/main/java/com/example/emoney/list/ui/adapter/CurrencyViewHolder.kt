package com.example.emoney.list.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.emoney.databinding.CurrencyListItemBinding
import com.example.emoney.list.domain.CurrencyRates
import java.text.NumberFormat

class CurrencyViewHolder(private val binding: CurrencyListItemBinding)
    : RecyclerView.ViewHolder(binding.root){

    fun bindItem(currency: CurrencyRates, currencyClicked: ((CurrencyRates)-> Unit )) {
        binding.root.setOnClickListener {
            currencyClicked(currency)
        }

        binding.currencyName.text = currency.currencyName
        binding.currencyRate.text = NumberFormat.getInstance().format(currency.rate)
    }
}