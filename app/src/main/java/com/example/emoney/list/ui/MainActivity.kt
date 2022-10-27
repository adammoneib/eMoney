package com.example.emoney.list.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emoney.databinding.ActivityMainBinding
import com.example.emoney.list.domain.CurrencyRates
import com.example.emoney.list.ui.adapter.CurrencyListAdapter
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var listAdapter: CurrencyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        initData()
    }

    private fun initUI() {
        listAdapter = CurrencyListAdapter { openDetails(it) }
        binding.currencyList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAdapter
            setHasFixedSize(true)
        }
    }

    private fun initData() {
        mainViewModel = MainViewModelProvider.provide(this)
        mainViewModel.ratesViewState.observe(this) { state ->
            state?.let {
                setViewState(it)
            }
        }
        mainViewModel.getRates()
    }

    private fun setViewState(state: RatesViewState) {
        when (state) {
            RatesViewState.Loading -> {}
            is RatesViewState.Success -> {
                binding.timeStamp.text = Date(state.rates.timestamp * 1000).toString()
                listAdapter.submitList(state.rates.currencyRates)
            }
            RatesViewState.Error -> {}
        }
    }

    private fun openDetails(rate: CurrencyRates) {

    }
}