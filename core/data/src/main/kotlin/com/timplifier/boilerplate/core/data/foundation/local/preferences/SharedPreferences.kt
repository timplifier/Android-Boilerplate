package com.timplifier.boilerplate.core.data.foundation.local.preferences

import android.content.SharedPreferences
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

abstract class Preferences(val prefs: SharedPreferences) {

    protected fun boolean(
        default: Boolean = false,
        key: String? = null
    ): ReadWriteProperty<Any, Boolean> =
        create(default, key, prefs::getBoolean, prefs.edit()::putBoolean)

    protected fun int(default: Int = 0, key: String? = null): ReadWriteProperty<Any, Int> =
        create(default, key, prefs::getInt, prefs.edit()::putInt)

    protected fun float(default: Float = 0f, key: String? = null): ReadWriteProperty<Any, Float> =
        create(default, key, prefs::getFloat, prefs.edit()::putFloat)

    protected fun long(default: Long = 0L, key: String? = null): ReadWriteProperty<Any, Long> =
        create(default, key, prefs::getLong, prefs.edit()::putLong)

    protected fun string(
        default: String = "",
        key: String? = null
    ): ReadWriteProperty<Any, String> =
        create(default, key, { k, d -> prefs.getString(k, d) as String }, prefs.edit()::putString)

    protected fun stringSet(
        default: Set<String> = emptySet(),
        key: String? = null
    ): ReadWriteProperty<Any, Set<String>> = create(
        default,
        key,
        { k, d -> prefs.getStringSet(k, d) as Set<String> },
        prefs.edit()::putStringSet
    )

    inline fun <reified T> nonPrimitive(
        default: T? = null,
        key: String? = null
    ): ReadWriteProperty<Any, T?> = create(
        default,
        key,
        { k, _ -> Json.decodeFromString(prefs.getString(k, "") as String) }, { k, v ->
            prefs.edit().putString(key, Json.encodeToString(v))
        }
    )

    fun <T> create(
        default: T,
        key: String? = null,
        getter: (key: String, default: T) -> T,
        setter: (key: String, value: T) -> SharedPreferences.Editor
    ) = object : ReadWriteProperty<Any, T> {
        private fun key(property: KProperty<*>) = key ?: property.name

        override fun getValue(thisRef: Any, property: KProperty<*>): T =
            getter(key(property), default)

        override fun setValue(thisRef: Any, property: KProperty<*>, value: T) =
            setter(key(property), value).apply()
    }
}