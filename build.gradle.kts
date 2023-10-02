plugins {
    alias(libs.plugins.agp.application) apply false
    alias(libs.plugins.agp.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.google.protobuf) apply false
    alias(libs.plugins.google.devtools.ksp) apply false
    alias(libs.plugins.google.services) apply false
}

tasks.register(projectConfig.versions.tasks.clean.get(), Delete::class) {
    delete(rootProject.buildDir)
}