package com.drbrosdev.currencyconverter.persistance.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.drbrosdev.currencyconverter.persistance.entity.DummyClass

@Database(
    entities = [DummyClass::class],
    version = 2,
    exportSchema = false
)
abstract class ApplicationDatabase : RoomDatabase() {

}