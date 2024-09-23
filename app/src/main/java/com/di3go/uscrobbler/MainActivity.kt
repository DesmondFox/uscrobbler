package com.di3go.uscrobbler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideInHorizontally
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import com.di3go.uscrobbler.screens.connect.ConnectPage
import com.di3go.uscrobbler.screens.lastfm_login.LastFMLoginScreen
import com.di3go.uscrobbler.ui.theme.UscrobblerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable


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
                    composable<LastFMLoginScreenObject>(
                        deepLinks = listOf(navDeepLink {
                            uriPattern = Contract.LASTFM_CALLBACK_URL
                        })
                    ) {
                        LastFMLoginScreen(
                            navController,
                            it.toRoute<LastFMLoginScreenObject>().token
                        )
                    }
                }
            }
        }
    }
}