package com.timplifier.boilerplate.feature.main.presentation.models

import com.timplifier.boilerplate.feature.main.domain.models.DummyModel

data class DummyUI(
    val id: Int,
    val name: String
)

fun DummyModel.toUI() = DummyUI(id, name)
