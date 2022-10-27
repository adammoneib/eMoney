package com.example.emoney.converter

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.emoney.databinding.ActivityDetailsBinding
import com.example.emoney.list.domain.CurrencyRates

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var targetCurrency: CurrencyRates

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        targetCurrency = intent.getParcelableExtra(KEY_TARGET_CURRENCY)!!

        binding.targetCurrencyName.text = targetCurrency.currencyName

        binding.Euro.editText?.doOnTextChanged { text, start, before, count ->
            if(text?.isNotEmpty() == true) {
                val input = text.toString().toDouble()
                binding.targetCurrency.editText?.setText("${input * targetCurrency.rate}")
            } else {
                binding.targetCurrency.editText?.setText("")

            }
        }
    }

    companion object {
        private const val KEY_TARGET_CURRENCY = "KEY_TARGET_CURRENCY"

        fun getIntent(context: Context, targetCurrency: CurrencyRates): Intent {
            return Intent(context, DetailsActivity::class.java).apply {
                putExtra(KEY_TARGET_CURRENCY, targetCurrency)
            }
        }
    }
}