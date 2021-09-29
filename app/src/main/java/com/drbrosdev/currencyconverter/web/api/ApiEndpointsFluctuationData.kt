package com.drbrosdev.currencyconverter.web.api

import com.drbrosdev.currencyconverter.web.dao.FluctuationDataDao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpointsFluctuationData {

    companion object {
        private const val apiHostFluctuationData = "https://api.exchangerate.host/fluctuation?"
    }

    @GET(apiHostFluctuationData)
    fun getFluctuationData(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String
    ): Call<FluctuationDataDao>

}