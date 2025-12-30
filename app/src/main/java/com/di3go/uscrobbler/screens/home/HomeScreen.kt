package com.di3go.uscrobbler.screens.home

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val vm = hiltViewModel<HomeVM>()

    LaunchedEffect(Unit) {
        Log.d("HomeScreen", "token: ${vm.getToken()}")
    }

    Scaffold {
        Surface(modifier = Modifier.padding(it)) {

        }
    }
}