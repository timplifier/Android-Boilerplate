package com.timplifier.boilerplate.feature.authentication.data.di.modules

import com.timplifier.boilerplate.feature.authentication.data.repositories.FooRepositoryImpl
import com.timplifier.boilerplate.feature.authentication.domain.repositories.FooRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsPhotosRepository(fooRepositoryImpl: FooRepositoryImpl): FooRepository
}