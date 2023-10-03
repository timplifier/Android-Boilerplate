package com.timplifier.boilerplate.feature.main.data.remote.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.timplifier.boilerplate.core.data.foundation.DTOMapper
import com.timplifier.boilerplate.feature.main.domain.models.FooModel
import io.ktor.resources.Resource
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity
@Serializable
@Resource("foo")
data class FooDTO(
    @PrimaryKey(autoGenerate = false)
    @SerialName("id")
    val id: Int,
    @SerialName("full_name")
    val name: String,
    @SerialName("dummy")
    val dummyDto: DummyDTO
) : DTOMapper<FooModel> {
    override fun toDomain(): FooModel = FooModel(id, name, dummyDto.toDomain())
}