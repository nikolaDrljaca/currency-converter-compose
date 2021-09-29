package com.drbrosdev.currencyconverter.web.dao

data class LatestCurrencyRateResponseDto(
    val base: String,
    val date: String,
    val motd: Motd,
    val rates: RatesDto,
    val success: Boolean
){

}