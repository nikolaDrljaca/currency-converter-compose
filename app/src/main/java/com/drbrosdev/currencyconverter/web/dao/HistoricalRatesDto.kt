package com.drbrosdev.currencyconverter.web.dao

data class HistoricalRatesDto(
    val base: String,
    val date: String,
    val historical: Boolean,
    val motd: Motd,
    val rates: RatesDto,
    val success: Boolean
){

}