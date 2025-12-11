package heaven.from.mywaifu.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import heaven.from.mywaifu.R
import heaven.from.mywaifu.ui.component.MyWaifuTopAppBar
import heaven.from.mywaifu.ui.component.MyWaifuTopAppBarMenu
import heaven.from.mywaifu.ui.constant.cornerSmall
import heaven.from.mywaifu.ui.layout.MyWaifuScaffold
import heaven.from.mywaifu.ui.view_model.HomeViewModel

@Composable
fun Dropdown(
    expanded: Boolean,
    onDismisRequest: () -> Unit,
    helpCallback: () -> Unit,
    settingsCallback: () -> Unit,
    aboutCallback: () -> Unit
) {
    DropdownMenu(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        ),
        shape = cornerSmall,
        expanded = expanded,
        onDismissRequest = onDismisRequest
    ) {
        DropdownMenuItem(
            trailingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    contentDescription = stringResource(R.string.help),
                    painter = painterResource(R.drawable.interrogation)
                )
            },
            text = {
                Text(
                    text = stringResource(R.string.help)
                )
           },
            onClick = helpCallback
        )
        HorizontalDivider()
        DropdownMenuItem(
            trailingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    contentDescription = stringResource(R.string.settings),
                    painter = painterResource(R.drawable.settings)
                )
            },
            text = {
                Text(
                    text = stringResource(R.string.settings)
                )
            },
            onClick = helpCallback
        )
        HorizontalDivider()
        DropdownMenuItem(
            trailingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    contentDescription = stringResource(R.string.about),
                    painter = painterResource(R.drawable.info)
                )
            },
            text = {
                Text(
                    text = stringResource(R.string.about)
                )
            },
            onClick = helpCallback
        )
    }
}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var dropdownExpanded by remember { mutableStateOf(false) }

    MyWaifuScaffold(
        topAppBar = {
            MyWaifuTopAppBar(
                title = stringResource(R.string.app_name),
                notificationCallback = {},
                searchCallback = { text -> },
                burgerContent = {
                    MyWaifuTopAppBarMenu(
                        modifier = Modifier.padding(end = 16.dp),
                        onClickCallback = {
                            dropdownExpanded = true
                        }
                    ) {
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            contentDescription = "More menu",
                            painter = painterResource(R.drawable.menu_burger)
                        )
                        Dropdown(
                            expanded = dropdownExpanded,
                            onDismisRequest = { dropdownExpanded = false },
                            helpCallback = {},
                            settingsCallback = {},
                            aboutCallback = {}
                        )
                    }
                }
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
