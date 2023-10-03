package com.timplifier.boilerplate.feature.authentication.presentation.models

import com.timplifier.boilerplate.feature.authentication.domain.models.DummyModel

data class DummyUI(
    val id: Int,
    val name: String
)

fun DummyModel.toUI() = DummyUI(id, name)
