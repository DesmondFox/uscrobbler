package com.di3go.uscrobbler

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.StrictMode
import dagger.hilt.android.HiltAndroidApp
import de.umass.lastfm.Caller
import java.io.File
import java.util.logging.Level

@HiltAndroidApp
class UApp: Application() {
    override fun onCreate() {
        super.onCreate()
//        Caller.getInstance().apply {
//            logger.level = Level.ALL
//            setCache(File(cacheDir, "lastfm-cache"), LASTFM_CACHE_SIZE)
//        }

        if (BuildConfig.DEBUG) {
            enableStrictMode()
        }
        setupNotificationChannel()
    }

    private fun setupNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            getString(R.string.playback_monitor),
            NotificationManager.IMPORTANCE_HIGH
        )
        (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).apply {
            createNotificationChannel(channel)
        }
    }

    private fun enableStrictMode() {
        StrictMode.enableDefaults()
    }

    companion object {
        const val LASTFM_CACHE_SIZE = 1024 * 1024 * 10
        const val CHANNEL_ID = "ServiceChannel"
    }
}