package com.timplifier.boilerplate.konsist.presentation

import com.timplifier.boilerplate.konsist.ClassAssertionTest
import org.junit.Test

internal class UIModelAssertionTest : ClassAssertionTest() {
    override val packageClassesResideIn = "..presentation..models.."
    override val classSuffix = "UI"

    @Test
    internal fun `ensure that all classes with 'UI' suffix reside in 'models' package`() {
        assertClassesPackage()
    }

    @Test
    internal fun `ensure that all classes that reside in 'models' package have 'UI' suffix`() {
        assertClassesThatResideInPackage()
    }

    @Test
    internal fun `classes with 'UI' suffix should have single 'extension' function to map their corresponding domain model`() {
        assertClassesThatResideInPackage {
            val hasSingleMapToUIExtensionMethod = containsFunction { function ->
                function.name == "toUI" && function.hasPublicOrDefaultModifier && function.hasReceiverType()
            }
            hasSingleMapToUIExtensionMethod && numPublicOrDefaultDeclarations() == 1
        }
    }
}