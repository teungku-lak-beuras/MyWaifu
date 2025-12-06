package heaven.from.mywaifu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.stringResource
import com.example.compose.MyWaifuTheme
import heaven.from.mywaifu.ui.components.MyWaifuTopAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyWaifuTheme {
                Column() {
                    MyWaifuTopAppBar(
                        title = stringResource(R.string.app_name),
                        notificationCallback = {},
                        settingsCallback = {},
                        searchCallback = { text -> }
                    )
                    MyWaifuTopAppBar(
                        title = stringResource(R.string.app_name),
                        popCallback = {},
                        notificationCallback = {}
                    )
                }
            }
        }
    }
}
