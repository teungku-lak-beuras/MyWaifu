package heaven.from.buildlogic

import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

fun configureKotlin(extension: KotlinAndroidProjectExtension) {
    extension.apply {
        compilerOptions {
            jvmTarget.set(JVM_TARGET_VERSION)
        }
    }
}
