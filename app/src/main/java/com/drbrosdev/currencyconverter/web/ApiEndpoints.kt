package com.drbrosdev.currencyconverter.web

import com.drbrosdev.currencyconverter.persistance.entity.DummyClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoints {

    @GET("dummy/endpoint")
    fun getDummyData(@Query("api_key") key: String): Call<DummyClass>

}