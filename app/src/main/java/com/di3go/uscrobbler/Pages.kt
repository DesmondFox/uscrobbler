package com.di3go.uscrobbler

import kotlinx.serialization.Serializable

@Serializable
object ConnectPageObject

@Serializable
object LastFMLoginScreenObject {
    var token: String = ""
}

@Serializable
object HomeScreenObject