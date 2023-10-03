package com.timplifier.boilerplate.core.data.foundation.local.database

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

@OptIn(InternalSerializationApi::class)
abstract class EntityConverter {

    protected val json = Json { allowStructuredMapKeys = true }

    protected inline fun <reified T : Any> fromJson(
        value: String?
    ): T? {
        if (value == null) return null
        return json.decodeFromString(T::class.serializer(), value)
    }

    protected inline fun <reified T : Any> toJson(
        value: T
    ): String {
        return json.encodeToString(T::class.serializer(), value)
    }
}