package heaven.from.mywaifu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.CompositionLocalProvider
import com.example.compose.MyWaifuTheme
import dagger.hilt.android.AndroidEntryPoint
import heaven.from.mywaifu.ui.navigation.MyWaifuRoot
import heaven.from.mywaifu.utility.LocalWindowSize
import heaven.from.mywaifu.utility.WindowSize

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            val windowSize = when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Medium -> WindowSize.Medium
                WindowWidthSizeClass.Expanded -> WindowSize.Expanded
                else -> WindowSize.Compact
            }

            CompositionLocalProvider(LocalWindowSize provides windowSize) {
                MyWaifuTheme {
                    MyWaifuRoot()
                }
            }
        }
    }
}
