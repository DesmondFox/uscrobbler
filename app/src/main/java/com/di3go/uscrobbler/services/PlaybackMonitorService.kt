package com.di3go.uscrobbler.services

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.di3go.uscrobbler.UApp

class PlaybackMonitorService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // start as foreground service

        val notification = NotificationCompat.Builder(this, UApp.CHANNEL_ID)
            .setContentTitle("Playback Monitor")
            .setOngoing(true)
            .setSilent(true)
            .build()
        startForeground(ID, notification)

        return START_STICKY
    }

    companion object {
        const val ID = 1
    }
}