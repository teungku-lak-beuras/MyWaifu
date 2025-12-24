plugins {
    alias(libs.plugins.heaven.from.android.library)
    alias(libs.plugins.heaven.from.hilt)
    alias(libs.plugins.heaven.from.ktor)
}

android {
    namespace = "heaven.from.core.repository"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:network"))
}
