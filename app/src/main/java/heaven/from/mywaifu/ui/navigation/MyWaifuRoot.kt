package heaven.from.mywaifu.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import heaven.from.mywaifu.ui.screen.AboutScreen
import heaven.from.mywaifu.ui.screen.HelpScreen
import heaven.from.mywaifu.ui.screen.HomeScreen
import heaven.from.mywaifu.ui.screen.SettingsScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun MyWaifuRoot() {
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(
                        MyWaifuRoutes.HomeScreen::class,
                        MyWaifuRoutes.HomeScreen.serializer()
                    )
                    subclass(
                        MyWaifuRoutes.HelpScreen::class,
                        MyWaifuRoutes.HelpScreen.serializer()
                    )
                    subclass(
                        MyWaifuRoutes.SettingsScreen::class,
                        MyWaifuRoutes.SettingsScreen.serializer()
                    )
                    subclass(
                        MyWaifuRoutes.AboutScreen::class,
                        MyWaifuRoutes.AboutScreen.serializer()
                    )
                }
            }
        },
        MyWaifuRoutes.HomeScreen
    )
    val durationMilliseconds = 200

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        transitionSpec = {
            slideInHorizontally(
                animationSpec = tween(durationMilliseconds),
                initialOffsetX = { it }
            ) + fadeIn(
                animationSpec = tween(durationMilliseconds)
            ) togetherWith ExitTransition.KeepUntilTransitionsFinished
        },
        popTransitionSpec = {
            EnterTransition.None togetherWith slideOutHorizontally(
                animationSpec = tween(durationMilliseconds),
                targetOffsetX = { it }
            ) + fadeOut(
                animationSpec = tween(durationMilliseconds)
            )
        },
        entryProvider = { key ->
            when (key) {
                is MyWaifuRoutes.HomeScreen -> {
                    NavEntry(key) {
                        HomeScreen(
                            helpCallback = {
                                backStack.add(MyWaifuRoutes.HelpScreen)
                            },
                            settingsCallback = {
                                backStack.add(MyWaifuRoutes.SettingsScreen)
                            },
                            aboutCallback = {
                                backStack.add(MyWaifuRoutes.AboutScreen)
                            }
                        )
                    }
                }
                is MyWaifuRoutes.HelpScreen -> {
                    NavEntry(key) {
                        HelpScreen(
                            popCallback = {
                                backStack.remove(MyWaifuRoutes.HelpScreen)
                            }
                        )
                    }
                }
                is MyWaifuRoutes.SettingsScreen -> {
                    NavEntry(key) {
                        SettingsScreen(
                            popCallback = {
                                backStack.remove(MyWaifuRoutes.SettingsScreen)
                            }
                        )
                    }
                }
                is MyWaifuRoutes.AboutScreen -> {
                    NavEntry(key) {
                        AboutScreen(
                            popCallback = {
                                backStack.remove(MyWaifuRoutes.AboutScreen)
                            }
                        )
                    }
                }
                else -> {
                    error("Unknown route: $key. :(")
                }
            }
        }
    )
}
