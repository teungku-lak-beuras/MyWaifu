package heaven.from.mywaifu.ui.layout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable

@Composable
fun MyWaifuSwitchingTopAppBar(
    expanded: Boolean,
    expandedTopAppBar: (@Composable () -> Unit),
    collapsedTopAppBar: (@Composable () -> Unit)
) {
    AnimatedVisibility(
        visible = expanded,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        expandedTopAppBar.invoke()
    }
    AnimatedVisibility(
        visible = !expanded,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        collapsedTopAppBar.invoke()
    }
}
