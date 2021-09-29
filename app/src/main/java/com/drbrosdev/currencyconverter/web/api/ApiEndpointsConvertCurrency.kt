package com.drbrosdev.currencyconverter.web.api

import com.drbrosdev.currencyconverter.web.dao.ConvertCurrencyDao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpointsConvertCurrency {

    companion object {
        private const val apiHostConvertCurrency = "https://api.exchangerate.host/convert?"
    }

    @GET(apiHostConvertCurrency)
    fun convertAmount(
        @Query("from") convertFrom: String,
        @Query("to") convertTo: String,
        @Query("amount") amount: Double
    ): Call<ConvertCurrencyDao>

    @GET(apiHostConvertCurrency)
    fun convertAmountWithRounding(
        @Query("from") convertFrom: String,
        @Query("to") convertTo: String,
        @Query("amount") amount: Double,
        @Query("places") places: Int
    )

}