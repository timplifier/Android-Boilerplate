package com.timplifier.boilerplate.konsist.domain.assertions

import com.timplifier.boilerplate.konsist.ClassAssertionTest
import org.junit.Test

internal class ModelAssertionTest : ClassAssertionTest() {
    override val packageClassesResideIn = "..domain..models.."

    override val classSuffix = "Model"

    @Test
    internal fun `ensure that all classes with 'Model' suffix reside in 'models' package`() {
        assertClassesPackage()
    }

    @Test
    internal fun `ensure that all classes that reside in 'models' package have 'Model' suffix`() {
        assertClassesThatResideInPackage()
    }
}