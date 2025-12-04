package heaven.from.buildlogic

import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

fun configureAndroidApplication(extension: BaseAppModuleExtension) {
    extension.apply {
        compileSdk = TARGET_SDK

        defaultConfig {
            minSdk = MIN_TARGET_SDK
            targetSdk = TARGET_SDK
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = JAVA_TARGET_VERSION
            targetCompatibility = JAVA_TARGET_VERSION
        }
    }
}

fun configureAndroidLibrary(extension: LibraryExtension) {
    extension.apply {
        compileSdk = TARGET_SDK

        compileOptions {
            sourceCompatibility = JAVA_TARGET_VERSION
            targetCompatibility = JAVA_TARGET_VERSION
        }
    }
}
