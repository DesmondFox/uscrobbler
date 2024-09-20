package com.di3go.uscrobbler

object Contract {
    const val USCROBBLER_SCHEME = "uscrobbler"
    const val LASTFM_LOGIN_URL = "https://www.last.fm/api/auth/?api_key=${BuildConfig.LFM_APIKEY}" +
            "&cb=${USCROBBLER_SCHEME}://lastfm"
}