plugins {
    alias(libs.plugins.heaven.from.android.application)
    alias(libs.plugins.heaven.from.compose)
    alias(libs.plugins.heaven.from.hilt)
    alias(libs.plugins.heaven.from.kotlin.serialization)
}

android {
    namespace = "heaven.from.mywaifu"

    defaultConfig {
        applicationId = "heaven.from.mywaifu"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }

        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // Delete when publishing.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(project(":core:repository"))
}
