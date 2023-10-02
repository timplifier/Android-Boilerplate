package com.timplifier.boilerplate.buildLogic.convention.extensions

import org.gradle.kotlin.dsl.DependencyHandlerScope

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