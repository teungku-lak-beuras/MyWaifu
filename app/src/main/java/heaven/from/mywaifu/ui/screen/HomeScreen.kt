package heaven.from.mywaifu.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import heaven.from.mywaifu.R
import heaven.from.mywaifu.ui.component.MyWaifuTopAppBar
import heaven.from.mywaifu.ui.layout.MyWaifuScaffold
import heaven.from.mywaifu.ui.view_model.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
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

@Preview
@Composable
fun HomeScreenPreview1() {
    HomeScreen()
}
