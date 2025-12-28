package heaven.from.mywaifu.utility

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.compose.MyWaifuTheme

@Composable
fun PreviewWrapper(
    windowSize: WindowSize = WindowSize.Compact,
    content: @Composable () -> Unit
) {
    MyWaifuTheme {
        CompositionLocalProvider(LocalWindowSize provides windowSize) {
            content.invoke()
        }
    }
}
