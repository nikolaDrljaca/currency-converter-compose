package com.drbrosdev.currencyconverter.web.dao

data class FluctuationDataDao(
    val endDate: String,
    val fluctuation: Boolean,
    val motd: Motd,
    val rates: RatesDto,
    val startDate: String,
    val success: Boolean
){

}