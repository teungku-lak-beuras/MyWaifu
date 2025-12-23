plugins {
    alias(libs.plugins.heaven.from.android.library)
}

android {
    namespace = "heaven.from.core.repository"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:network"))
}
