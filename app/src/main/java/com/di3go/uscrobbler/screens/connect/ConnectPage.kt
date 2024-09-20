package com.di3go.uscrobbler.screens.connect

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.di3go.uscrobbler.BuildConfig
import com.di3go.uscrobbler.LastFMLoginScreenObject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectPage(navController: NavHostController) {
    val viewModel = hiltViewModel<ConnectVM>()

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
                Button(onClick = { navController.navigate(LastFMLoginScreenObject) }) {
                    Text(text = "Connect")
                }
            }

        }
    }
}