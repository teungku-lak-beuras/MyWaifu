package heaven.from.mywaifu.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import heaven.from.mywaifu.R
import heaven.from.mywaifu.ui.component.MyWaifuTopAppBarPortrait
import heaven.from.mywaifu.ui.layout.MyWaifuScaffold

@Composable
fun SettingsScreen(
    popCallback: () -> Unit
) {
    MyWaifuScaffold(
        topAppBar = {
            MyWaifuTopAppBarPortrait(
                title = stringResource(R.string.settings),
                popCallback = popCallback,
                notificationCallback = {}
            )
        }
    ) { paddingValues ->
        Text(
            modifier = Modifier.padding(paddingValues),
            text = "Settings screen is under construction :)"
        )
    }
}

@Preview
@Composable
fun SettingsScreenPreview1 () {
    SettingsScreen(
        popCallback = {}
    )
}