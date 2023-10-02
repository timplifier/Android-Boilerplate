package com.timplifier.boilerplate.buildLogic.convention.plugins.base

import com.timplifier.boilerplate.buildLogic.convention.extensions.extractPluginId
import com.timplifier.boilerplate.buildLogic.convention.extensions.extractPrimitive
import com.timplifier.boilerplate.buildLogic.convention.extensions.libs
import com.timplifier.boilerplate.buildLogic.convention.extensions.projectConfig
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal abstract class KotlinLibraryPlugin(private val configuration: Project.() -> Unit = {}) :
    Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply(libs.plugins.java.library.extractPluginId())
                apply(libs.plugins.kotlin.jvm.extractPluginId())
            }

            extensions.configure<JavaPluginExtension> {
                sourceCompatibility =
                    JavaVersion.values()[projectConfig.versions.kotlin.options.jvm.extractPrimitive<Int>() - 1]
                targetCompatibility =
                    JavaVersion.values()[projectConfig.versions.kotlin.options.jvm.extractPrimitive<Int>() - 1]
            }

            tasks.withType<KotlinCompile>().configureEach {
                kotlinOptions {
                    jvmTarget = projectConfig.versions.kotlin.options.jvm.get()
                }
            }

            configuration()
        }
    }
}