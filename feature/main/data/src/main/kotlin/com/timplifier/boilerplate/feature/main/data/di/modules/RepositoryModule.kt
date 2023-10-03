package com.timplifier.boilerplate.feature.main.data.di.modules

import com.timplifier.boilerplate.feature.main.data.repositories.FooRepositoryImpl
import com.timplifier.boilerplate.feature.main.domain.repositories.FooRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsPhotosRepository(fooRepositoryImpl: FooRepositoryImpl): FooRepository
}