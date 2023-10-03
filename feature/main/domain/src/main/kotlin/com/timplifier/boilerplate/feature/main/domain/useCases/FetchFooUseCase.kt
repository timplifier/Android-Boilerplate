package com.timplifier.boilerplate.feature.main.domain.useCases

import com.timplifier.boilerplate.feature.main.domain.repositories.FooRepository
import javax.inject.Inject

class FetchFooUseCase @Inject constructor(private val fooRepository: FooRepository) {

    operator fun invoke() = fooRepository.someFunction()
}