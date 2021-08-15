package com.drbrosdev.currencyconverter.persistance.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DummyClass(
    @PrimaryKey val id: Int,
    val title: String
) {

}
