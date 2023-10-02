package com.timplifier.boilerplate.buildLogic.convention.plugins.layers

import org.gradle.kotlin.dsl.dependencies
import com.timplifier.boilerplate.buildLogic.convention.extensions.api
import com.timplifier.boilerplate.buildLogic.convention.extensions.implementation
import com.timplifier.boilerplate.buildLogic.convention.extensions.libs
import com.timplifier.boilerplate.buildLogic.convention.plugins.base.KotlinLibraryPlugin

internal class DomainPlugin : KotlinLibraryPlugin({
    dependencies {
        if (path.split(":").first { it.isNotBlank() } != "core")
            api(project(":core:domain"))
        implementation(libs.bundles.kotlinx.core)
        implementation(libs.androidx.paging.common)
        implementation(libs.javax.inject)
    }
})