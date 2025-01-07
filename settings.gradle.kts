pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "decompose-dagger-sample"

include(":app-android")
include(":repository")
include(":utils")
include(":feature-root")
include(":feature-list")
include(":feature-details")
