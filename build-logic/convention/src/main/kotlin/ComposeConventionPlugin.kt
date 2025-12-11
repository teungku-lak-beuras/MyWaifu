
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import heaven.from.buildlogic.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with (target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with (pluginManager) {
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureCompose(this)
            }

            dependencies {
                add("implementation", libs.findLibrary("androidx-material3").get())
                add("implementation", libs.findLibrary("androidx-navigation3-runtime").get())
                add("implementation", libs.findLibrary("androidx-navigation3-ui").get())
                add("implementation", libs.findLibrary("androidx-lifecycle-viewmodel-navigation3").get())

                add("implementation", libs.findLibrary("androidx-activity-compose").get())
                add("implementation", platform(libs.findLibrary("androidx-compose-bom").get()))
                add("androidTestImplementation", platform(libs.findLibrary("androidx-compose-bom").get()))

                add("androidTestImplementation", libs.findLibrary("androidx-compose-ui-test-junit4").get())

                add("implementation", libs.findLibrary("androidx-compose-ui").get())
                add("implementation", libs.findLibrary("androidx-compose-ui-graphics").get())
                add("implementation", libs.findLibrary("androidx-compose-ui-tooling-preview").get())
                add("implementation", libs.findLibrary("androidx-compose-ui-text").get())
                add("implementation", libs.findLibrary("androidx-compose-material3").get())
                add("implementation", libs.findLibrary("androidx-compose-material3-window-size-class1").get())
                add("debugImplementation", libs.findLibrary("androidx-compose-ui-tooling").get())
                add("debugImplementation", libs.findLibrary("androidx-compose-ui-test-manifest").get())
            }
        }
    }
}
