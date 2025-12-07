package heaven.from.mywaifu.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import heaven.from.mywaifu.ui.component.MyWaifuTopAppBar

@Composable
fun MyWaifuScaffold(
    topAppBar: (@Composable () -> Unit),
    content: (@Composable (PaddingValues) -> Unit)
) {
    var spacerHeight by remember { mutableIntStateOf(0) }

    Surface(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .windowInsetsPadding(WindowInsets.navigationBars),
        color = MaterialTheme.colorScheme.surface
    ) {
        Box(
            modifier = Modifier
                .onGloballyPositioned { layoutCoordinates ->
                    spacerHeight = layoutCoordinates.size.height
            }
        ) {
            topAppBar.invoke()
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            content.invoke(
                PaddingValues(
                    top = with (LocalDensity.current) {
                        spacerHeight.toDp()
                    }
                )
            )
        }
    }
}

@Preview
@Composable
fun MyWaifuScaffoldPreview1() {
    MyWaifuScaffold(
        topAppBar = {
            MyWaifuTopAppBar(
                title = "Administrator",
                notificationCallback = {},
                settingsCallback = {},
                searchCallback = {}
            )
        },
        content = { paddingValues ->
            Text(
                modifier = Modifier
                    .padding(paddingValues),
                text = "Hello world!"
            )
        }
    )
}
