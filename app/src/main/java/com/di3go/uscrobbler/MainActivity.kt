package com.di3go.uscrobbler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideInHorizontally
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.di3go.uscrobbler.screens.connect.ConnectPage
import com.di3go.uscrobbler.ui.theme.UscrobblerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            UscrobblerTheme {
                NavHost(
                    navController = navController,
                    startDestination = ConnectPageObject,
                    enterTransition = { slideInHorizontally() },
                ) {
                    composable<ConnectPageObject> { ConnectPage(navController) }
                }
            }
        }
    }
}