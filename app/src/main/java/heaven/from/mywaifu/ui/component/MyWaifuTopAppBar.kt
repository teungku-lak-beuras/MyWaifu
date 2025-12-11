package heaven.from.mywaifu.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

private val shape = RoundedCornerShape(
    bottomStart = 32.dp,
    bottomEnd = 32.dp,
)

@Composable
fun MyWaifuTopAppBar(
    title: String,
    popCallback: () -> Unit,
    notificationCallback: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .height(96.dp)
            .fillMaxWidth()
            .clip(shape),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column(
            modifier = Modifier.padding(
                top = 16.dp,
                bottom = 16.dp
            ),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(64.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                        .clickable(onClick = popCallback),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        contentDescription = "Notifications",
                        painter = painterResource(R.drawable.arrow_small_left)
                    )

                }
                Text(
                    style = MaterialTheme.typography.titleLarge,
                    text = title
                )
                Surface(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(64.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                        .clickable(onClick = notificationCallback),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        contentDescription = "Notifications",
                        painter = painterResource(R.drawable.bell)
                    )
                }
            }
        }
    }
}

@Composable
fun MyWaifuTopAppBar(
    title: String,
    notificationCallback: () -> Unit,
    settingsCallback: () -> Unit,
    searchCallback: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .height(176.dp)
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
                Surface(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(64.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                        .clickable(onClick = notificationCallback),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        contentDescription = "Notifications",
                        painter = painterResource(R.drawable.bell)
                    )

                }
                Surface(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(64.dp)
                        .clip(
                            RoundedCornerShape(16.dp)
                        )
                        .clickable(onClick = settingsCallback),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        contentDescription = "Settings",
                        painter = painterResource(R.drawable.menu_burger)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // We will add this search input callback last!
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

@Preview
@Composable
fun MyWaifuTopAppBarPreview1() {
    MyWaifuTopAppBar(
        title = "Administrator",
        notificationCallback = {},
        settingsCallback = {},
        searchCallback = {}
    )
}

@Preview
@Composable
fun MyWaifuTopAppBarPreview2() {
    MyWaifuTopAppBar(
        title = "Detail page",
        popCallback = {},
        notificationCallback = {}
    )
}
