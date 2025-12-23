
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import heaven.from.core.network.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.cio.CIOEngineConfig
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DebugMode

@Module
@InstallIn(SingletonComponent::class)
class NekosBestApiModule {
    private val timeout: Long = 30_000

    @Provides
    @BaseUrl
    fun provideBaseUrl(): String = BuildConfig.nekosBestApi

    @Provides
    @DebugMode
    fun provideLogging(): Boolean = BuildConfig.DEBUG

    @Provides
    fun provideEngine(): HttpClientEngineFactory<CIOEngineConfig> = CIO

    @Provides
    @Singleton
    fun createHttpClient(
        @BaseUrl baseUrl: String,
        @DebugMode debugMode: Boolean,
        engine: HttpClientEngineFactory<CIOEngineConfig>
    ): HttpClient {
        return HttpClient(engineFactory = engine) {
            defaultRequest {
                url(baseUrl)
            }

            if (debugMode) {
                install(Logging) {
                    logger = Logger.ANDROID
                    level = LogLevel.BODY
                }
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true // Just in case of sudden API changes.
                    }
                )
            }

            install(HttpTimeout) {
                connectTimeoutMillis = timeout
                requestTimeoutMillis = timeout
                socketTimeoutMillis = timeout
            }
        }
    }
}
