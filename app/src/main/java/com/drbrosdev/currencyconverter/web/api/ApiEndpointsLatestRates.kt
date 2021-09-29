package com.drbrosdev.currencyconverter.web.api

import com.drbrosdev.currencyconverter.web.dao.LatestCurrencyRateResponseDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpointsLatestRates {

    companion object {
        private const val apiHostLatestRates = "https://api.exchangerate.host/latest"
    }

    @GET(apiHostLatestRates)
    fun getLatestRates(): Call<LatestCurrencyRateResponseDto>

    @GET("$apiHostLatestRates?source=crypto")
    fun getLatestCryptoRates(): Call<LatestCurrencyRateResponseDto>

    @GET(apiHostLatestRates)
    fun convertAmount(@Query("amount") amount: Double): Call<LatestCurrencyRateResponseDto>

}