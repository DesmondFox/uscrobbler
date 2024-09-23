package com.di3go.uscrobbler.screens.lastfm_login

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.di3go.uscrobbler.Contract

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LastFMLoginScreen(navController: NavController, token: String) {
    val vm = hiltViewModel<LastFMLoginVM>()
    val args = navController.currentBackStackEntry?.arguments

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Login")
            })
        }
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ) {
            Text("Token $token")
        }
    }
}
