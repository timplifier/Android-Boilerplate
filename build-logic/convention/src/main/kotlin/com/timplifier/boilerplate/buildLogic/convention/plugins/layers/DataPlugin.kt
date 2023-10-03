package com.timplifier.boilerplate.buildLogic.convention.plugins.layers

import com.timplifier.boilerplate.buildLogic.convention.extensions.extractPluginId
import com.timplifier.boilerplate.buildLogic.convention.extensions.implementation
import com.timplifier.boilerplate.buildLogic.convention.extensions.ksp
import com.timplifier.boilerplate.buildLogic.convention.extensions.libs
import com.timplifier.boilerplate.buildLogic.convention.plugins.base.AndroidLibraryPlugin
import org.gradle.kotlin.dsl.dependencies

internal class DataPlugin : AndroidLibraryPlugin(projectConfiguration = {

    pluginManager.apply {
        apply(libs.plugins.kotlin.serialization.extractPluginId())
        apply(libs.plugins.google.devtools.ksp.extractPluginId())
    }

    dependencies {
        if (path.split(":").first { it.isNotBlank() } != "core")
            implementation(project(":core:data"))
        implementation(project(path.replace(":data", ":domain")))
        implementation(libs.bundles.kotlinx.core)
        implementation(libs.bundles.ktor.client)
        implementation(libs.androidx.paging)
        implementation(libs.androidx.room.runtime)
        implementation(libs.androidx.room.ktx)
        implementation(libs.google.dagger)
        ksp(libs.google.dagger.compiler)
        ksp(libs.androidx.room.compiler)
    }
}, releaseLibraryBuildType = {
    buildConfigField("String", "DEV_BASE_URL", "\"http://android-boilerplate.com/\"")
    buildConfigField("String", "DEV_WEBSOCKET_URL", "\"ws://android-boilerplate/ws/\"")
}, buildFeaturesConfiguration = {
    buildConfig = true
}
)