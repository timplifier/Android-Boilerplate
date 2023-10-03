package com.timplifier.boilerplate.feature.main.presentation.models

import com.timplifier.boilerplate.feature.main.domain.models.FooModel

data class FooUI(
    val id: Int,
    val name: String,
    val dummyDto: DummyUI
)

fun FooModel.toUI() = FooUI(id, name, dummyModel.toUI())