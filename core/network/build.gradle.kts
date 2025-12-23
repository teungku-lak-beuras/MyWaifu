plugins {
    alias(libs.plugins.heaven.from.android.library)
    alias(libs.plugins.heaven.from.hilt)
    alias(libs.plugins.heaven.from.ktor)
}

android {
    namespace = "heaven.from.core.network"

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        val nekosBestApi = "https://nekos.best/api/v2/"

        debug {
            buildConfigField("String", "nekosBestApi", "\"$nekosBestApi\"")
        }

        release {
            buildConfigField("String", "nekosBestApi", "\"$nekosBestApi\"")
        }
    }
}

dependencies {
    implementation(project(":core:model"))
}
