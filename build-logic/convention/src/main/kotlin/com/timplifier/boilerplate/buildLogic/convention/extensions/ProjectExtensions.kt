package com.timplifier.boilerplate.buildLogic.convention.extensions

import org.gradle.accessors.dm.LibrariesForAndroidProjectConfig
import org.gradle.accessors.dm.LibrariesForProjectConfig
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.DependencyHandlerScope

private inline fun <reified T> Project.retrieveExtension(name: String): T where T : AbstractExternalDependencyFactory {
    return (this as ExtensionAware).extensions.getByName(name) as T
}

internal inline val Project.libs: LibrariesForLibs
    inline get() =
        retrieveExtension("libs")

internal inline val Project.androidProjectConfig: LibrariesForAndroidProjectConfig
    inline get() = retrieveExtension("androidProjectConfig")

internal inline val Project.projectConfig: LibrariesForProjectConfig
    inline get() = retrieveExtension("projectConfig")

internal fun DependencyHandlerScope.implementation(dependencyNotation: Any) {
    "implementation"(dependencyNotation)
}

internal fun DependencyHandlerScope.testImplementation(dependencyNotation: Any) {
    "testImplementation"(dependencyNotation)
}

internal fun DependencyHandlerScope.androidTestImplementation(dependencyNotation: Any) {
    "androidTestImplementation"(dependencyNotation)
}

internal fun DependencyHandlerScope.debugImplementation(dependencyNotation: Any) {
    "debugImplementation"(dependencyNotation)
}

internal fun DependencyHandlerScope.api(dependencyNotation: Any) {
    "api"(dependencyNotation)
}

internal fun DependencyHandlerScope.ksp(dependencyNotation: Any) {
    "ksp"(dependencyNotation)
}

internal fun DependencyHandlerScope.coreLibraryDesugaring(dependencyNotation: Any) {
    "coreLibraryDesugaring"(dependencyNotation)
}