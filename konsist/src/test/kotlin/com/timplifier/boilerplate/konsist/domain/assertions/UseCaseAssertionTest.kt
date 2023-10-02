package com.timplifier.boilerplate.konsist.domain.assertions

import com.timplifier.boilerplate.konsist.ClassAssertionTest
import org.junit.Test

internal class UseCaseAssertionTest : ClassAssertionTest() {
    override val packageClassesResideIn = "..domain..useCases.."

    override val classSuffix = "UseCase"

    @Test
    internal fun `ensure that all classes with 'UseCase' suffix reside in 'useCases' package`() {
        assertClassesPackage()
    }

    @Test
    internal fun `ensure that all classes that reside in 'useCases' package have 'UseCase' suffix`() {
        assertClassesThatResideInPackage()
    }

    @Test
    internal fun `classes with 'UseCase' suffix should have single 'constructor' parameter as 'repository' and parameter name matches the source type`() {
        assertClassesThatResideInPackage {
            !hasInitBlocks && !hasSecondaryConstructors && hasPrimaryConstructor && numConstructors == 1
        }
        assertClassesConstructorsParametersThatResideInPackage {
            val upperCasedParameterName =
                name.replaceFirstChar { char -> char.uppercase() }
            hasPrivateModifier && hasValModifier && type.hasNameEndingWith("Repository") && upperCasedParameterName == type.sourceType
        }
    }

    @Test
    internal fun `classes with 'UseCase' suffix should have single 'public operator' method named 'invoke'`() {
        assertClassesThatResideInPackage {
            val hasSingleInvokeOperatorMethod = containsFunction { function ->
                function.name == "invoke" && function.hasPublicOrDefaultModifier && function.hasOperatorModifier
            }

            hasSingleInvokeOperatorMethod && numPublicOrDefaultDeclarations() == 1
        }
    }
}