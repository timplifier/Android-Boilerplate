enableFeaturePreview("STABLE_CONFIGURATION_CACHE")
dependencyResolutionManagement {

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    versionCatalogs {

        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }

        create("androidProjectConfig") {
            from(files("../gradle/android-project-config.versions.toml"))
        }

        create("projectConfig") {
            from(files("../gradle/project-config.versions.toml"))
        }

        create("pluginsConfig") {
            from(files("gradle/plugins-config.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")