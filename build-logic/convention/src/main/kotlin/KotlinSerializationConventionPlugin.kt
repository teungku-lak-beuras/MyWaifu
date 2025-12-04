import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class KotlinSerializationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with (target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with (pluginManager) {
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                add("implementation", libs.findLibrary("kotlin-seralization").get())
            }
        }
    }
}
