package com.example.emoney.list.domain

import com.example.emoney.core.DefaultApiClient
import com.example.emoney.list.data.ConverterRemoteDataSource
import com.example.emoney.list.data.RatesMapper
import com.example.emoney.list.data.RatesRemoteRepo

object GetRatesUseCaseProvider {

    private fun provideMapper() = RatesMapper

    private fun provideRemoteDataSource(): ConverterRemoteDataSource = DefaultApiClient.getInstance().create(ConverterRemoteDataSource::class.java)

    private fun provideRemoteRepo() = RatesRemoteRepo(mapper = provideMapper(), remote = provideRemoteDataSource())

    fun provide(): GetRatesUseCase {
        return GetRatesUseCase(provideRemoteRepo())
    }
}