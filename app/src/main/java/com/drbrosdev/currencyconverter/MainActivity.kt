package com.drbrosdev.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.drbrosdev.currencyconverter.ui.screens.home.HomeScreenComposable
import com.drbrosdev.currencyconverter.ui.theme.CurrencyConverterTheme
import com.drbrosdev.currencyconverter.web.ServiceBuilder
import com.drbrosdev.currencyconverter.web.api.ApiEndpointsConvertCurrency
import com.drbrosdev.currencyconverter.web.api.ApiEndpointsFluctuationData
import com.drbrosdev.currencyconverter.web.api.ApiEndpointsLatestRates

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api =
            ServiceBuilder.buildService(ApiEndpointsLatestRates::class.java, applicationContext)
        val apiConvertCurrency =
            ServiceBuilder.buildService(ApiEndpointsConvertCurrency::class.java, applicationContext)
        val apiFluctuationData =
            ServiceBuilder.buildService(ApiEndpointsFluctuationData::class.java, applicationContext)
        setContent {
            CurrencyConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        HomeScreenComposable(
                            api = api,
                            apiConvertCurrency = apiConvertCurrency,
                            apiFluctuationData = apiFluctuationData
                        )
                    }
                }
            }
        }
    }
}

