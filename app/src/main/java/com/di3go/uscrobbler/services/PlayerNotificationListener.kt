package com.di3go.uscrobbler.services

import android.app.Notification
import android.media.MediaMetadata
import android.media.session.MediaController
import android.media.session.MediaSession
import android.media.session.PlaybackState
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class PlayerNotificationListener : NotificationListenerService() {
    private val musicAppsPackageNames = listOf(
        "com.spotify.music",
        "com.apple.android.music",
        "com.google.android.apps.youtube.music",
        "com.maxmpz.audioplayer",
    )

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)

        val packageName = sbn?.packageName
        val extras = sbn?.notification?.extras
        val title = extras?.getCharSequence(Notification.EXTRA_TITLE)
        val text = extras?.getCharSequence(Notification.EXTRA_TEXT)
        val subText = ""
        val notificationId = sbn?.id

        if (title != null && text != null) {

            // Handle the notification data as needed
            // For example, you can log it or display a Toast
            if (packageName in musicAppsPackageNames) {
                val isMedia = sbn.notification.extras.containsKey(Notification.EXTRA_MEDIA_SESSION)

                if (isMedia) {
                    val mediaSession = sbn.notification.extras.getParcelable<MediaSession.Token>(Notification.EXTRA_MEDIA_SESSION)
                    mediaSession?.let {
                        val controller = MediaController(this, it)
                        val playbackState = controller.playbackState
                        val position = playbackState?.position ?: 0
                        val isPlaying = playbackState?.state == PlaybackState.STATE_PLAYING
                        val duration = controller.metadata?.getLong(MediaMetadata.METADATA_KEY_DURATION)

                        Log.d("PlayerNotificationListener", "Notification id: $notificationId")
                        Log.d("PlayerNotificationListener", "Position: $position from $duration")
                        Log.d("PlayerNotificationListener", "Is Playing: $isPlaying")
                        Log.d("PlayerNotificationListener", "Title: $title")
                        Log.d("PlayerNotificationListener", "Text: $text")
                        Log.d("PlayerNotificationListener", "SubText: $subText")
                        Log.d("PlayerNotificationListener", "Package: $packageName")
                        Log.d("PlayerNotificationListener", "State: ${playbackState?.state}")
                        Log.d("PlayerNotificationListener", "------")
                    }
                }
            }
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)

        val packageName = sbn?.packageName
        if (packageName in musicAppsPackageNames) {
            val notificationId = sbn?.id

            Log.d("PlayerNotificationListener", "Notification removed: $notificationId")
        }
    }
}