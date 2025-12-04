package heaven.from.buildlogic

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

fun configureCompose(extension: BaseAppModuleExtension) {
    extension.apply {
        buildFeatures {
            compose = true
        }
    }
}
