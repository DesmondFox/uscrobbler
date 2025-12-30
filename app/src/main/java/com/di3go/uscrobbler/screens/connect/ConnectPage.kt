package com.di3go.uscrobbler.screens.connect

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.di3go.uscrobbler.BuildConfig
import com.di3go.uscrobbler.Contract
import com.di3go.uscrobbler.LastFMLoginScreenObject
import com.di3go.uscrobbler.services.PlaybackMonitorService
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun ConnectPage(navController: NavHostController) {
    val viewModel = hiltViewModel<ConnectVM>()
    val context = LocalContext.current
    val postNotificationPermissionState = rememberPermissionState(
        android.Manifest.permission.POST_NOTIFICATIONS
    )

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Connect")
            })
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Connect to Last.fm")
                Text(text = "Version: ${BuildConfig.VERSION_NAME}")
                Button(onClick = {
                    Intent(Intent.ACTION_VIEW, Uri.parse(Contract.LASTFM_LOGIN_URL)).also {
                        context.startActivity(it)
                    }
                }) {
                    Text(text = "Connect")
                }
                Button(onClick = {
                    Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS").apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }.also { intent ->
                        context.startActivity(intent)
                    }
                }) {
                    Text("Notification settings")
                }
                Button(onClick = {
                    postNotificationPermissionState.launchPermissionRequest()
                }, enabled = !postNotificationPermissionState.status.isGranted) {
                    Text(
                        text = if (postNotificationPermissionState.status.isGranted)
                            "Permission already granted"
                        else
                            "Ask for post notification permission"
                    )
                }
                Button(onClick = {
                    Intent(context, PlaybackMonitorService::class.java).also {
                        context.startService(it)
                    }
                }) {
                    Text(text = "Start playback monitor service")
                }
            }
        }
    }
}