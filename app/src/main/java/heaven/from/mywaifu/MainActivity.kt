package heaven.from.mywaifu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose.MyWaifuTheme
import dagger.hilt.android.AndroidEntryPoint
import heaven.from.mywaifu.ui.component.MyWaifuTopAppBar
import heaven.from.mywaifu.ui.layout.MyWaifuScaffold

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<MainViewModel>()

            MyWaifuTheme {
                MyWaifuScaffold(
                    topAppBar = {
                        MyWaifuTopAppBar(
                            title = stringResource(R.string.app_name),
                            notificationCallback = {},
                            settingsCallback = {},
                            searchCallback = { text -> }
                        )
                    }
                ) { paddingValues ->
                    Text(
                        modifier = Modifier.padding(paddingValues),
                        text = viewModel.helloWorld
                    )
                }
            }
        }
    }
}
