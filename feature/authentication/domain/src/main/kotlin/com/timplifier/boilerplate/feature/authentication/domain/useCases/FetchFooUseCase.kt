package com.timplifier.boilerplate.feature.authentication.domain.useCases

import com.timplifier.boilerplate.feature.authentication.domain.repositories.FooRepository
import javax.inject.Inject

class FetchFooUseCase @Inject constructor(private val fooRepository: FooRepository) {

    operator fun invoke() = fooRepository.someFunction()
}