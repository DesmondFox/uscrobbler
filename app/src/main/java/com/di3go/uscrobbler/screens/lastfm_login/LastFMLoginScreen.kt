package com.di3go.uscrobbler.screens.lastfm_login

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
fun LastFMLoginScreen(navController: NavController) {
    val vm = hiltViewModel<LastFMLoginVM>()
    val webViewClient: WebViewClient = WebViewClient()

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
            AndroidView(factory = { context ->
                WebView(context).apply {
                    this.layoutParams = android.view.ViewGroup.LayoutParams(
                        android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                        android.view.ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    this.webViewClient = webViewClient
                }
            }, update = { webView ->
                webView.loadUrl(Contract.LASTFM_LOGIN_URL)
            })
        }
    }
}