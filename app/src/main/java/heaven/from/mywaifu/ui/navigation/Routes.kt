package heaven.from.mywaifu.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes : NavKey {
    @Serializable
    data object HomeScreen : Routes, NavKey
}
