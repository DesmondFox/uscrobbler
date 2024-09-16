package com.di3go.uscrobbler.screens.connect

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectPage(navController: NavHostController) {
    val viewModel = hiltViewModel<ConnectVM>()

    Scaffold(
        topBar = {
            TopAppBar(title = { /*TODO*/ })
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {

        }
    }
}