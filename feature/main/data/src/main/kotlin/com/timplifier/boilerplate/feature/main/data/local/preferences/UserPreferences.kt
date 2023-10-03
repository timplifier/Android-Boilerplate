package com.timplifier.boilerplate.feature.authentication.data.local.preferences

import android.content.SharedPreferences
import com.timplifier.boilerplate.core.data.foundation.local.preferences.Preferences
import javax.inject.Inject

class UserPreferences @Inject constructor(
    private val sharedPreferences: SharedPreferences

) : Preferences(sharedPreferences) {

    var isAuthenticated by boolean()
}