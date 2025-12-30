package com.di3go.uscrobbler.services

import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.di3go.uscrobbler.R
import com.di3go.uscrobbler.UApp
import com.di3go.uscrobbler.data.models.TrackInfo

class PlaybackMonitorService : Service() {
    private var isForeground = false

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // start as foreground service

        if (intent?.action == ACTION_NEW_TRACK) {
            val trackInfo = intent.getParcelableExtra<TrackInfo>(ACTION_NEW_TRACK)
            trackInfo?.let {
                updateNotification(it)
            }
        }

        return START_STICKY
    }

    private fun updateNotification(trackInfo: TrackInfo) {
        val notification = NotificationCompat.Builder(this, UApp.CHANNEL_ID)
            .setContentTitle(getString(R.string.now_playing))
            .setContentText("${trackInfo.artist} - ${trackInfo.title}")
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setOngoing(true)
            .build()

        if (!isForeground) {
            startForeground(NOTIFICATION_ID, notification)
            isForeground = true
        } else {
            (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).notify(
                NOTIFICATION_ID,
                notification
            )
        }
    }

    companion object {
        const val NOTIFICATION_ID = 1
        const val ACTION_NEW_TRACK = "com.di3go.uscrobbler.ACTION_NEW_TRACK"
    }
}