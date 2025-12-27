package heaven.from.mywaifu

import android.app.Application
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.request.crossfade
import coil3.util.DebugLogger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyWaifuApplication : Application(), SingletonImageLoader.Factory {
    override fun newImageLoader(context: PlatformContext): ImageLoader {
        return ImageLoader
            .Builder(context)
            .logger(if (BuildConfig.DEBUG) DebugLogger() else null)
            .crossfade(true)
            .build()
    }
}
