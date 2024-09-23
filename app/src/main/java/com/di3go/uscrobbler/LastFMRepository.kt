package com.di3go.uscrobbler

import android.util.Log
import de.umass.lastfm.Caller
import javax.inject.Inject
import javax.inject.Singleton

interface LastFMRepository {
    fun saveToken(token: String)
}

@Singleton
class LastFMRepositoryImpl @Inject constructor(
    private val caller: Caller
): LastFMRepository {

    override fun saveToken(token: String) {
        TODO("Not yet implemented")
    }
}