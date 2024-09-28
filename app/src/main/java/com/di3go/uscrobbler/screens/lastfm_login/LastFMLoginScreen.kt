package com.di3go.uscrobbler.screens.lastfm_login

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
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

        }
    }
}
