import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "heaven.from.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradle)
    compileOnly(libs.kotlin.gradle)
}

gradlePlugin {
    plugins {
        register("AndroidApplicationConventionPlugin") {
            id = "heaven.from.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("AndroidLibraryConventionPlugin") {
            id = "heaven.from.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("ComposeConventionPlugin") {
            id = "heaven.from.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("HiltConventionPlugin") {
            id = "heaven.from.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("KotlinSerializationConventionPlugin") {
            id = "heaven.from.kotlin.serialization"
            implementationClass = "KotlinSerializationConventionPlugin"
        }
        register("KtorConventionPlugin") {
            id = "heaven.from.ktor"
            implementationClass = "KtorConventionPlugin"
        }
    }
}
