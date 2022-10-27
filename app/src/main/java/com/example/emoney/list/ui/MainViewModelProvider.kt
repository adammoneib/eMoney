package com.example.emoney.list.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.emoney.list.domain.GetRatesUseCaseProvider

object MainViewModelProvider {

    private fun provideGetHeroesUseCase() = GetRatesUseCaseProvider.provide()

    fun provide(owner: AppCompatActivity) = ViewModelProvider(
        owner = owner,
        MainViewModelFactory(
            useCase = provideGetHeroesUseCase()
        )
    ).get(MainViewModel::class.java)
}