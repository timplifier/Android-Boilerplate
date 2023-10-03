package com.timplifier.boilerplate.feature.main.data.remote.dtos

import com.timplifier.boilerplate.core.data.foundation.DTOMapper
import com.timplifier.boilerplate.feature.main.domain.models.DummyModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
) : DTOMapper<DummyModel> {
    override fun toDomain(): DummyModel = DummyModel(id, name)
}