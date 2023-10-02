package com.timplifier.boilerplate.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.declaration.KoClassDeclaration
import com.lemonappdev.konsist.api.declaration.KoConstructorDeclaration
import com.lemonappdev.konsist.api.declaration.KoFileDeclaration
import com.lemonappdev.konsist.api.declaration.KoFunctionDeclaration
import com.lemonappdev.konsist.api.declaration.KoInterfaceDeclaration
import com.lemonappdev.konsist.api.declaration.KoParameterDeclaration
import com.lemonappdev.konsist.api.declaration.KoPropertyDeclaration
import com.lemonappdev.konsist.api.ext.list.constructors
import com.lemonappdev.konsist.api.ext.list.functions
import com.lemonappdev.konsist.api.ext.list.parameters
import com.lemonappdev.konsist.api.ext.list.properties
import com.lemonappdev.konsist.api.ext.list.withAllAnnotationsOf
import com.lemonappdev.konsist.api.ext.list.withPackage
import com.lemonappdev.konsist.api.verify.assert
import kotlin.reflect.KClass

internal abstract class ClassAssertionTest {
    abstract val packageClassesResideIn: String

    protected open val classSuffix: String = ""

    protected open var koScope = Konsist.scopeFromProject()

    protected fun assertFilesPackage(
        filter: KoFileDeclaration.() -> Boolean = { name.endsWith(classSuffix) },
        assertion: KoFileDeclaration .() -> Boolean = { name.endsWith(classSuffix) }
    ) {
        koScope.files.filter(filter)
            .assert(assertion)
    }

    protected fun assertFilesThatResideInPackage(
        assertion: KoFileDeclaration.() -> Boolean = { name.endsWith(classSuffix) }
    ) {
        koScope.files.withPackage(packageClassesResideIn)
            .assert(assertion)
    }

    protected fun assertFilesAndInterfacesTheyContain(
        fileAssertion: KoFileDeclaration.() -> Boolean = { name.endsWith(classSuffix) },
        interfaceAssertion: KoInterfaceDeclaration.() -> Boolean
    ) {
        assertFilesPackage {
            fileAssertion() && containsInterface(predicate = interfaceAssertion)
        }
    }

    protected fun assertFilesAndInterfacesTheyContainThatResideInPackage(
        fileAssertion: KoFileDeclaration.() -> Boolean = { name.endsWith(classSuffix) },
        interfaceAssertion: KoInterfaceDeclaration.() -> Boolean = { name.endsWith(classSuffix) }
    ) {
        assertFilesThatResideInPackage {
            fileAssertion() && containsInterface(predicate = interfaceAssertion)
        }
    }

    protected fun assertClassesPackage(
        filter: KoClassDeclaration.() -> Boolean = { name.endsWith(classSuffix) },
    ) {
        koScope.classes()
            .filter(filter)
            .assert { it.resideInPackage(packageClassesResideIn) }
    }

    protected fun assertClassesThatResideInPackage(
        assertion: KoClassDeclaration.() -> Boolean = { name.endsWith(classSuffix) }
    ) {
        koScope.classes().withPackage(packageClassesResideIn)
            .assert(assertion)
    }

    protected fun filterAndAssertClassesThatResideInPackage(
        filter: KoClassDeclaration.() -> Boolean,
        assertion: KoClassDeclaration.() -> Boolean = { name.endsWith(classSuffix) }
    ) {
        koScope.classes().withPackage(packageClassesResideIn).filter(filter)
            .assert(assertion)
    }

    protected fun filterAndAssertClassesFunctionsThatResideInPackage(
        filter: KoClassDeclaration.() -> Boolean,
        assertion: KoFunctionDeclaration.() -> Boolean = { name.endsWith(classSuffix) }
    ) {
        koScope.classes().withPackage(packageClassesResideIn).filter { filter(it) }.functions()
            .assert(assertion)
    }

    protected fun assertClassesConstructorsThatResideInPackage(
        assertion: KoConstructorDeclaration.() -> Boolean
    ) {
        koScope.classes().withPackage(packageClassesResideIn).constructors.assert(assertion)
    }

    protected fun assertClassesConstructorsParametersThatResideInPackage(
        assertion: KoParameterDeclaration.() -> Boolean
    ) {
        koScope.classes().withPackage(packageClassesResideIn).constructors.parameters.assert(
            assertion
        )
    }

    protected fun filterByAnnotationAndAssertClassesPropertiesThatResideInPackage(
        annotationToFilterBy: KClass<*>,
        assertion: KoPropertyDeclaration.() -> Boolean
    ) {
        koScope.classes().withPackage(packageClassesResideIn)
            .withAllAnnotationsOf(annotationToFilterBy).properties().assert(assertion)
    }
}