package org.tbm.walletleaks.buildlogic.convention.plugins.layers

import org.gradle.kotlin.dsl.dependencies
import com.timplifier.boilerplate.buildLogic.convention.extensions.extractPluginId
import com.timplifier.boilerplate.buildLogic.convention.extensions.implementation
import com.timplifier.boilerplate.buildLogic.convention.extensions.ksp
import com.timplifier.boilerplate.buildLogic.convention.extensions.libs
import com.timplifier.boilerplate.buildLogic.convention.plugins.base.AndroidLibraryPlugin

internal class DataPlugin : AndroidLibraryPlugin(projectConfiguration = {

    pluginManager.apply {
        apply(libs.plugins.kotlin.serialization.extractPluginId())
        apply(libs.plugins.google.devtools.ksp.extractPluginId())
        apply(libs.plugins.google.protobuf.extractPluginId())
    }

    dependencies {
        if (path.split(":").first { it.isNotBlank() } != "core")
            implementation(project(":core:data"))
        implementation(project(path.replace(":data", ":domain")))
        implementation(libs.bundles.kotlinx.core)
        implementation(libs.bundles.ktor.client)
        implementation(libs.androidx.paging)
        implementation(libs.androidx.datastore)
        implementation(libs.google.dagger)
        ksp(libs.google.dagger.compiler)
    }
}, releaseLibraryBuildType = {
    buildConfigField("String", "DEV_BASE_URL", "\"http://134.122.75.14:8999/\"")
    buildConfigField("String", "DEV_WEBSOCKET_URL", "\"ws://134.122.75.14:8999/ws/\"")
}, buildFeaturesConfiguration = {
    buildConfig = true
}
)