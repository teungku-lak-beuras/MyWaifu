package heaven.from.repository

import heaven.from.model.WaifuModelV1
import heaven.from.repository.state.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository
@Inject
constructor(
    private val nekosBestApiRepository: NekosBestApiRepository
) {
    fun getNetworkWaifu(amount: Int): Flow<ApiState<List<WaifuModelV1>>> {
        return nekosBestApiRepository
            .getWaifu(amount = amount)
            .flowOn(Dispatchers.IO)
    }
}
