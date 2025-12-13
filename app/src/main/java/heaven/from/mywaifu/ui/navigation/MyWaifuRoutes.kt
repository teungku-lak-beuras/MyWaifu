package heaven.from.mywaifu.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface MyWaifuRoutes : NavKey {
    @Serializable
    data object HomeScreen : MyWaifuRoutes, NavKey

    @Serializable
    data object HelpScreen : MyWaifuRoutes, NavKey
}
