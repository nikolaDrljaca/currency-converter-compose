package com.drbrosdev.currencyconverter.web.dao

data class ConvertCurrencyDao(
    val date: String,
    val historical: Boolean,
    val info: InfoDto,
    val motd: Motd,
    val query: QueryDto,
    val result: Double,
    val success: Boolean
) {

}