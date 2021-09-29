package com.drbrosdev.currencyconverter.web.api

import com.drbrosdev.currencyconverter.web.dao.HistoricalRatesDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndpointsHistoricalRates {

    companion object{
        private const val apiHost = "https://api.exchangerate.host"
    }

    @GET("${apiHost}/{date}")
    fun getHistoricalRates(@Path("date") date: String): Call<HistoricalRatesDto>

}