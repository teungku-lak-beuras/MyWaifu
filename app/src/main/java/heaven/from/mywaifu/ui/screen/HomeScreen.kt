package heaven.from.mywaifu.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import heaven.from.model.WaifuModelV1
import heaven.from.mywaifu.R
import heaven.from.mywaifu.ui.component.MyWaifuTopAppBar
import heaven.from.mywaifu.ui.component.MyWaifuTopAppBarMenu
import heaven.from.mywaifu.ui.constant.cornerSmall
import heaven.from.mywaifu.ui.layout.MyWaifuScaffold
import heaven.from.mywaifu.ui.view_model.HomeViewModel
import heaven.from.repository.state.ApiState

@Composable
fun Dropdown(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    helpCallback: () -> Unit,
    settingsCallback: () -> Unit,
    aboutCallback: () -> Unit
) {
    DropdownMenu(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        shape = cornerSmall,
        expanded = expanded,
        onDismissRequest = onDismissRequest
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
            onClick = settingsCallback
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
            onClick = aboutCallback
        )
    }
}

@Composable
fun LoadingItem() {
    Image(
        modifier = Modifier.size(72.dp),
        contentDescription = stringResource(R.string.loading),
        painter = painterResource(R.drawable.picture)
    )
    Text(
        modifier = Modifier.padding(8.dp),
        style = MaterialTheme.typography.bodyLarge,
        text = stringResource(R.string.loading)
    )
}

@Composable
fun SuccessItem(
    waifu: WaifuModelV1
) {
    val shape = RoundedCornerShape(16.dp)

    Surface(
        modifier = Modifier.clip(shape = shape),
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Column() {
            Text(
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                text = "Waifu artist's name: ${waifu.artistName}"
            )
            Text(
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                text = "Waifu taken from: ${waifu.sourceUrl}"
            )
            Text(
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                text = "Waifu image: ${waifu.url}"
            )
        }
    }
}

@Composable
fun ErrorItem() {
    Image(
        modifier = Modifier.size(72.dp),
        contentDescription = stringResource(R.string.error),
        painter = painterResource(R.drawable.error_bug)
    )
    Text(
        modifier = Modifier.padding(8.dp),
        style = MaterialTheme.typography.bodyLarge,
        text = stringResource(R.string.error)
    )
}

@Composable
fun Content(
    modifier: Modifier,
    waifu: ApiState<List<WaifuModelV1>>
) {
    when (waifu) {
        is ApiState.Loading -> {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LoadingItem()
            }
        }
        is ApiState.Success -> {
            LazyVerticalGrid(
                modifier = modifier,
                columns = GridCells.Adaptive(128.dp),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    items = waifu.data
                ) { item ->
                    SuccessItem(waifu = item)
                }
            }
        }
        is ApiState.Error -> {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ErrorItem()
            }
        }
    }
}

@Composable
fun HomeScreen(
    helpCallback: () -> Unit,
    settingsCallback: () -> Unit,
    aboutCallback: () -> Unit,
    waifu: ApiState<List<WaifuModelV1>>
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
                            onDismissRequest = { dropdownExpanded = false },
                            helpCallback = {
                                dropdownExpanded = false
                                helpCallback.invoke()
                            },
                            settingsCallback = {
                                dropdownExpanded = false
                                settingsCallback.invoke()
                            },
                            aboutCallback = {
                                dropdownExpanded = false
                                aboutCallback.invoke()
                            }
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Content(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            waifu = waifu
        )
    }
}

@Composable
fun HomeRoute(
    helpCallback: () -> Unit,
    settingsCallback: () -> Unit,
    aboutCallback: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        helpCallback = helpCallback,
        settingsCallback = settingsCallback,
        aboutCallback = aboutCallback,
        waifu = viewModel.waifu.collectAsStateWithLifecycle().value
    )
}

@Preview
@Composable
fun HomeScreenPreview1() {
    HomeScreen(
        helpCallback = {},
        settingsCallback = {},
        aboutCallback = {},
        waifu = ApiState.Success(
            data = listOf(
                WaifuModelV1(
                    artistName = "Yagen",
                    artistHref = "https://www.pixiv.net/en/users/39846570",
                    sourceUrl = "https://www.pixiv.net/en/artworks/128662564",
                    url = "https://nekos.best/api/v2/waifu/5cd32e1d-351f-43c3-93ac-9f9ac51d58b1.png"
                ),
                WaifuModelV1(
                    artistName = "Yagen",
                    artistHref = "https://www.pixiv.net/en/users/39846570",
                    sourceUrl = "https://www.pixiv.net/en/artworks/128662564",
                    url = "https://nekos.best/api/v2/waifu/5cd32e1d-351f-43c3-93ac-9f9ac51d58b1.png"
                )
            )
        )
    )
}
