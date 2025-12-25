package heaven.from.mywaifu.ui.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import heaven.from.model.WaifuModelV1
import heaven.from.repository.Repository
import heaven.from.repository.state.ApiState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val repository: Repository
) : ViewModel() {
    private val waifus_ = mutableStateOf<ApiState<List<WaifuModelV1>>>(ApiState.Loading)
    val waifu = waifus_.value

    init {
        getWaifu()
    }

    fun getWaifu(amount: Int = 15) = viewModelScope.launch {
        repository.getNetworkWaifu(amount = amount).collect { value ->
            when (value) {
                is ApiState.Loading -> {
                    waifus_.value = value
                }
                is ApiState.Success -> {
                    waifus_.value = value
                }
                is ApiState.Error -> {
                    waifus_.value = value
                }
            }
        }
    }
}
