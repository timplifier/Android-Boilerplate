package com.timplifier.boilerplate.buildLogic.convention.extensions

import org.gradle.api.provider.Provider
import org.gradle.plugin.use.PluginDependency

internal inline fun <reified T : Any> Provider<String>.extractPrimitive(): T {
    val stringValue = get()
    return when (T::class) {
        Int::class -> stringValue.toInt()
        Long::class -> stringValue.toLong()
        Short::class -> stringValue.toShort()
        Byte::class -> stringValue.toByte()
        Double::class -> stringValue.toDouble()
        Float::class -> stringValue.toFloat()
        Char::class -> {
            if (stringValue.length == 1) stringValue[0]
            else throw IllegalArgumentException("Cannot convert $stringValue to Char")
        }

        Boolean::class -> stringValue.toBoolean()
        else -> throw IllegalArgumentException("Unsupported type: ${T::class.java}")
    } as T
}

internal fun Provider<PluginDependency>.extractPluginId() = get().pluginId