package com.example.emoney.core

import android.app.Application
import com.example.emoney.core.DefaultApiClient

class EMoneyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DefaultApiClient.init()
    }
}