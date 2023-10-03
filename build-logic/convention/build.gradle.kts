import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    id(libs.plugins.google.protobuf.get().pluginId) version (libs.plugins.google.protobuf.get().version.displayName)
}

java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = projectConfig.versions.kotlin.options.jvm.get()
    }
}
sourceSets {
    main {
        kotlin {
            srcDir("../.gradle/7.5.1/dependencies-accessors")
        }
    }
}

dependencies {
    compileOnly(libs.agp.tools.gradle)
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.google.devtools.ksp)
}

gradlePlugin {
    plugins {

        with(libs.plugins.boilerplate) {
            register(android.plain.get().pluginId) {
                id = android.plain.get().pluginId
                implementationClass =
                    pluginsConfig.versions.android.plain.implementation.get()
            }

            register(layer.data.get().pluginId) {
                id = layer.data.get().pluginId
                implementationClass =
                    pluginsConfig.versions.layer.data.implementation.get()
            }

            register(layer.domain.get().pluginId) {
                id = layer.domain.get().pluginId
                implementationClass =
                    pluginsConfig.versions.layer.domain.implementation.get()
            }

            register(layer.presentation.get().pluginId) {
                id = layer.presentation.get().pluginId
                implementationClass =
                    pluginsConfig.versions.layer.presentation.implementation.get()
            }
        }
    }
}