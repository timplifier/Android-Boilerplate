package com.timplifier.boilerplate.konsist.domain.assertions

import com.timplifier.boilerplate.konsist.ClassAssertionTest
import org.junit.Test

internal class RepositoryAssertionTest : ClassAssertionTest() {
    override val packageClassesResideIn = "..domain..repositories.."

    override val classSuffix: String = "Repository"

    @Test
    internal fun `ensure that all files with 'Repository' suffix are interfaces and reside in 'repositories' package`() {
        assertFilesAndInterfacesTheyContain {
            name.endsWith(classSuffix) && resideInPackage(packageClassesResideIn)
        }
    }

    @Test
    internal fun `ensure that all files that reside in 'repositories' package are interfaces and have 'Repository' suffix`() {
        assertFilesAndInterfacesTheyContainThatResideInPackage()
    }

    @Test
    internal fun `classes with 'Repository' suffix should have single interface declaration and contain no classes`() {
        assertFilesAndInterfacesTheyContainThatResideInPackage(fileAssertion = {
            name.endsWith(
                classSuffix
            ) && numClasses() == 0 && numInterfaces() == 1
        }) { hasPublicOrDefaultModifier }
    }
}