package com.di3go.uscrobbler.screens.lastfm_login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LastFMLoginScreen(navController: NavController) {
    val vm = hiltViewModel<LastFMLoginVM>()
    val args = navController.currentBackStackEntry?.arguments
    val token = args?.getString("token")
    val isTokenSaved = vm.isTokenSaved.collectAsState()

    LaunchedEffect(Unit) {
        token?.let {
            vm.saveToken(it)
        }
    }

    if (isTokenSaved.value) {
        navController.navigate("home")
    }

    SavingTokenScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavingTokenScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Saving token")
            })
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(1.0f),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
    }
}

@Preview(
    apiLevel = 35, showSystemUi = true,
)
@Composable
fun PreviewLastFMLoginScreen() {
    SavingTokenScreen()
}