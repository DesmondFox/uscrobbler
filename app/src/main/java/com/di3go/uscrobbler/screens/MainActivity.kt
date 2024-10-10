package com.di3go.uscrobbler.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideInHorizontally
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.di3go.uscrobbler.ConnectPageObject
import com.di3go.uscrobbler.Contract
import com.di3go.uscrobbler.HomeScreenObject
import com.di3go.uscrobbler.screens.connect.ConnectPage
import com.di3go.uscrobbler.screens.home.HomeScreen
import com.di3go.uscrobbler.screens.lastfm_login.LastFMLoginScreen
import com.di3go.uscrobbler.ui.theme.UscrobblerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val vm = hiltViewModel<MainVM>()

            UscrobblerTheme {
                NavHost(
                    navController = navController,
                    startDestination = ConnectPageObject,
                    enterTransition = { slideInHorizontally() },
                ) {
                    composable<ConnectPageObject> {
                        if (vm.hasToken()) {
                            HomeScreen(navController)
                        } else {
                            ConnectPage(navController)
                        }
                    }
                    composable(
                        route = "/lastfm_login",
                        deepLinks = listOf(navDeepLink {
                            uriPattern = Contract.LASTFM_DEEPLINK_PATTERN
                        }),
                        arguments = listOf(
                            navArgument("token") { type = NavType.StringType; defaultValue = "" }
                        )
                    ) {
                        LastFMLoginScreen(navController)
                    }
                    composable<HomeScreenObject> { HomeScreen(navController) }
                }
            }
        }
    }
}