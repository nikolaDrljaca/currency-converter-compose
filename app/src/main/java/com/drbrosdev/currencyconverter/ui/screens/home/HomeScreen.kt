package com.drbrosdev.currencyconverter.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.drbrosdev.currencyconverter.web.api.ApiEndpointsConvertCurrency
import com.drbrosdev.currencyconverter.web.api.ApiEndpointsFluctuationData
import com.drbrosdev.currencyconverter.web.api.ApiEndpointsLatestRates


@Composable
fun HomeScreenComposable(
    api: ApiEndpointsLatestRates,
    apiConvertCurrency: ApiEndpointsConvertCurrency,
    apiFluctuationData: ApiEndpointsFluctuationData
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                // test api calls
            },
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text(text = "Api Call")
        }
    }
}