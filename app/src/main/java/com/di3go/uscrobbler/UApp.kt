package com.di3go.uscrobbler

import android.app.Application
import android.os.StrictMode
import de.umass.lastfm.Caller
import java.io.File
import java.util.logging.Level

class UApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Caller.getInstance().apply {
            logger.level = Level.ALL
            setCache(File(cacheDir, "lastfm-cache"), LASTFM_CACHE_SIZE)
        }

        if (BuildConfig.DEBUG) {
            enableStrictMode()
        }
    }

    private fun enableStrictMode() {
        StrictMode.enableDefaults()
    }

    companion object {
        const val LASTFM_CACHE_SIZE = 1024 * 1024 * 10
    }
}