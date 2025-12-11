package heaven.from.mywaifu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.compose.MyWaifuTheme
import dagger.hilt.android.AndroidEntryPoint
import heaven.from.mywaifu.ui.navigation.MyWaifuRoot

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWaifuTheme {
                MyWaifuRoot()
            }
        }
    }
}
