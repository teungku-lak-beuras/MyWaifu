package heaven.from.mywaifu.utility

import androidx.compose.runtime.staticCompositionLocalOf

enum class WindowSize {
    Compact,
    Medium,
    Expanded
}

val LocalWindowSize = staticCompositionLocalOf<WindowSize> {
    error("WindowSizeClass isn't yet prepared. Must be contained within setContent().")
}
