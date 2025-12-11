package heaven.from.mywaifu.ui.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor() : ViewModel() {
    var helloWorld by mutableStateOf("NICEEE!!! :)))))"); private set
}
