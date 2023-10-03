package com.timplifier.boilerplate.feature.authentication.data.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.timplifier.boilerplate.feature.authentication.data.local.database.FooDatabase
import com.timplifier.boilerplate.feature.authentication.data.local.database.daos.FooDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object LocalModule {

    @Singleton
    @Provides
    fun generateRoomDatabase(context: Context) = Room
        .databaseBuilder(context, FooDatabase::class.java, "fooDatabase")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun generateFooDao(roomDatabase: FooDatabase): FooDao =
        roomDatabase.fooDao()

    @Singleton
    @Provides
    fun generateSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(
            "preferences_name",
            Context.MODE_PRIVATE
        )
}