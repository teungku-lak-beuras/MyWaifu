package heaven.from.network

import heaven.from.network.response.NekosBestApiResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NekosBestApiDataSource
@Inject
constructor(
    private val client: HttpClient
) {
    suspend fun getWaifu(amount: Int): NekosBestApiResponse {
        return client.get(
            urlString = "waifu"
        ) {
            url {
                parameters.append("amount", amount.toString())
            }
        }.body()
    }
}
