package com.timplifier.boilerplate.feature.main.data.local.database.converters

import androidx.room.TypeConverter
import com.timplifier.boilerplate.core.data.foundation.local.database.EntityConverter
import com.timplifier.boilerplate.feature.main.data.remote.dtos.DummyDTO

class FooConverter : EntityConverter() {

    @TypeConverter
    fun fromDummy(value: String?) = fromJson<DummyDTO>(value)

    @TypeConverter
    fun toDummy(dummy: DummyDTO): String = toJson<DummyDTO>(dummy)
}