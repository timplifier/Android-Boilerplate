package com.timplifier.boilerplate.feature.authentication.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.timplifier.boilerplate.feature.authentication.data.local.database.converters.FooConverter
import com.timplifier.boilerplate.feature.authentication.data.local.database.daos.FooDao
import com.timplifier.boilerplate.feature.authentication.data.remote.dtos.FooDTO

@Database(entities = [FooDTO::class], version = 1, exportSchema = false)
@TypeConverters(FooConverter::class)
abstract class FooDatabase : RoomDatabase() {
    abstract fun fooDao(): FooDao
}