package com.example.emoney.list.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.emoney.R
import com.example.emoney.databinding.CurrencyListItemBinding
import com.example.emoney.list.domain.CurrencyRates

class CurrencyListAdapter(
    private val currencyRateClicked: (CurrencyRates) -> Unit
): ListAdapter<CurrencyRates, RecyclerView.ViewHolder>(RatesDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.currency_list_item, parent, false)
        return CurrencyViewHolder(CurrencyListItemBinding.bind(itemView))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CurrencyViewHolder).bindItem(getItem(position), currencyRateClicked)
    }
}