package com.timplifier.boilerplate.konsist.domain.assertions.architecture

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import org.junit.Test

internal class DomainLayerArchitectureTest {

    @Test
    internal fun `ensure that domain layer is independent`() {
        val coreDomain =
            Layer("Core Domain", "com.timplifier.boilerplate.core.domain..")
        Konsist.scopeFromProject()
            .assertArchitecture {
                listOf(
                    "com.timplifier.boilerplate.authentication.domain..",
                    "com.timplifier.boilerplate.main.domain.."
                ).forEach { definedBy ->
                    val domain = Layer(definedBy, definedBy)
                    domain.dependsOn(coreDomain)
                }
            }
    }
}