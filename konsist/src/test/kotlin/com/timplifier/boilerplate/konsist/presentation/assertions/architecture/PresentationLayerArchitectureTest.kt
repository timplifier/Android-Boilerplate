package com.timplifier.boilerplate.konsist.presentation.assertions.architecture

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import org.junit.Test

internal class PresentationLayerArchitectureTest {
    @Test
    internal fun `ensure that presentation layer depends only on core and domain`() {
        val corePresentation =
            Layer("Core Presentation", "com.timplifier.boilerplate.core.presentation..")
        Konsist.scopeFromProject()
            .assertArchitecture {
                listOf(
                    "com.timplifier.boilerplate.authentication.presentation..",
                    "com.timplifier.boilerplate.main.presentation.."
                ).forEach { definedBy ->
                    val presentation = Layer(definedBy, definedBy)
                    val domain =
                        Layer(
                            definedBy.replace("presentation", "domain"),
                            definedBy.replace("presentation", "domain")
                        )
                    presentation.dependsOn(corePresentation)
                    presentation.dependsOn(domain)
                }
            }
    }
}