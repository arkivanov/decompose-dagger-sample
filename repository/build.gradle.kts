plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.anvil)
}

android {
    namespace = "com.example.myapplication.repository"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
}

dependencies {
    implementation(project(":utils"))
    implementation(libs.dagger.dagger)
    implementation(libs.anvil.annotations)
}

anvil {
    useKsp(contributesAndFactoryGeneration = true)
    generateDaggerFactories = true
}
