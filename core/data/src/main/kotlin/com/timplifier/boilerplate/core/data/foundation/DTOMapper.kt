package com.timplifier.boilerplate.core.data.foundation

interface DTOMapper<T> {
    fun toDomain(): T
}