package heaven.from.mywaifu.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import heaven.from.mywaifu.R
import heaven.from.mywaifu.ui.constant.collapsedHeight
import heaven.from.mywaifu.ui.constant.expandedHeight
import heaven.from.mywaifu.ui.constant.shape

@Composable
fun MyWaifuTopAppBarLandscape(
    title: String,
    collapseCallback: () -> Unit,
    notificationCallback: () -> Unit,
    searchCallback: (String) -> Unit,
    burgerContent: @Composable () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .height(expandedHeight)
            .fillMaxWidth()
            .clip(shape),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp
                        )
                        .weight(3f)
                ) {
                    Text(
                        style = MaterialTheme.typography.titleSmall,
                        text = "${stringResource(R.string.welcome)},"
                    )
                    Text(
                        style = MaterialTheme.typography.titleLarge,
                        text = title
                    )
                }
                MyWaifuTopAppBarMenu(
                    modifier = Modifier.padding(end = 16.dp),
                    onClickCallback = notificationCallback
                ) {
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        contentDescription = "Notifications",
                        painter = painterResource(R.drawable.bell)
                    )
                }
                burgerContent.invoke()
                MyWaifuTopAppBarMenu(
                    modifier = Modifier.padding(end = 16.dp),
                    onClickCallback = collapseCallback
                ) {
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        contentDescription = "Notifications",
                        painter = painterResource(R.drawable.caret_up)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(64.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        ),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = MaterialTheme.colorScheme.surface,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surface
                    ),
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.padding(16.dp),
                            contentDescription = "Search",
                            painter = painterResource(R.drawable.search)
                        )
                    },
                    placeholder = {
                        Text("Search...")
                    },
                    lineLimits = TextFieldLineLimits.SingleLine,
                    state = rememberTextFieldState()
                )
            }
        }
    }
}

@Composable
fun MyWaifuTopAppBarLandscape(
    expandCallback: () -> Unit,
    notificationCallback: () -> Unit,
    searchCallback: (String) -> Unit,
    burgerContent: @Composable () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .height(collapsedHeight)
            .fillMaxWidth()
            .clip(shape),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Row(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    bottom = 16.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                    .height(64.dp)
                    .weight(3f)
                    .clip(
                        RoundedCornerShape(16.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                trailingIcon = {
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        contentDescription = "Search",
                        painter = painterResource(R.drawable.search)
                    )
                },
                placeholder = {
                    Text("Search...")
                },
                lineLimits = TextFieldLineLimits.SingleLine,
                state = rememberTextFieldState()
            )
            MyWaifuTopAppBarMenu(
                modifier = Modifier.padding(end = 16.dp),
                onClickCallback = notificationCallback
            ) {
                Icon(
                    modifier = Modifier.padding(16.dp),
                    contentDescription = "Notifications",
                    painter = painterResource(R.drawable.bell)
                )
            }
            burgerContent.invoke()
            MyWaifuTopAppBarMenu(
                modifier = Modifier.padding(end = 16.dp),
                onClickCallback = expandCallback
            ) {
                Icon(
                    modifier = Modifier.padding(16.dp),
                    contentDescription = "Notifications",
                    painter = painterResource(R.drawable.caret_down)
                )
            }
        }
    }
}

@Preview(device = "spec:parent=pixel_5,orientation=landscape")
@Composable
fun MyWaifuTopAppBarLandscapePreview1() {
    MyWaifuTopAppBarLandscape(
        title = "Administrator",
        collapseCallback = {},
        notificationCallback = {},
        searchCallback = {}
    )
}

@Preview(device = "spec:parent=pixel_5,orientation=landscape")
@Composable
fun MyWaifuTopAppBarLandscapePreview2() {
    MyWaifuTopAppBarLandscape(
        expandCallback = {},
        notificationCallback = {},
        searchCallback = {}
    )
}
