plugins {
    id(libs.plugins.boilerplate.android.plain.get().pluginId)
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.lemonappdev.konsist)
    implementation(libs.junit)
    testImplementation(libs.lemonappdev.konsist)
    testImplementation(libs.junit)
}