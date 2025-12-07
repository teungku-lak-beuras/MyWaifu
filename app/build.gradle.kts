plugins {
    alias(libs.plugins.heaven.from.android.application)
    alias(libs.plugins.heaven.from.compose)
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
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
