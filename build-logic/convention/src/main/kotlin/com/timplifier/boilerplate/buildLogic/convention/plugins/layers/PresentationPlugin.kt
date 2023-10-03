package com.timplifier.boilerplate.buildLogic.convention.plugins.layers

import org.gradle.kotlin.dsl.dependencies
import com.timplifier.boilerplate.buildLogic.convention.extensions.extractPluginId
import com.timplifier.boilerplate.buildLogic.convention.extensions.implementation
import com.timplifier.boilerplate.buildLogic.convention.extensions.ksp
import com.timplifier.boilerplate.buildLogic.convention.extensions.libs
import com.timplifier.boilerplate.buildLogic.convention.plugins.base.AndroidLibraryPlugin

internal class PresentationPlugin : AndroidLibraryPlugin({

    pluginManager.apply {
        apply(libs.plugins.kotlin.serialization.extractPluginId())
        apply(libs.plugins.google.devtools.ksp.extractPluginId())
    }

    dependencies {
        if (path.split(":").first { it.isNotBlank() } != "core")
            implementation(project(":core:presentation"))
        implementation(project(path.replace(":presentation", ":domain")))
        implementation(libs.bundles.androidx.compose)
        implementation(libs.bundles.kotlinx.android)
        implementation(libs.google.dagger)
        ksp(libs.google.dagger.compiler)
    }
}, buildFeaturesConfiguration = {
    compose = true
})