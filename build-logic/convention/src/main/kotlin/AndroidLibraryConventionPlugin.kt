import com.android.build.api.dsl.LibraryExtension
import heaven.from.buildlogic.configureAndroidLibrary
import heaven.from.buildlogic.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with (target) {
            with (pluginManager) {
            }

            extensions.configure<LibraryExtension> {
                configureAndroidLibrary(this)
            }

            extensions.configure<KotlinAndroidProjectExtension> {
                configureKotlin(this)
            }
        }
    }
}
