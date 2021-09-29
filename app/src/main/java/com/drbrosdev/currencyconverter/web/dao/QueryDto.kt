package com.drbrosdev.currencyconverter.web.dao

data class QueryDto(
    val amount: Int,
    val from: String,
    val to: String
) {
}