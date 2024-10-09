package com.di3go.uscrobbler.data.providers

import com.di3go.uscrobbler.data.repositories.SecuredPrefsRepository
import de.umass.lastfm.Caller
import javax.inject.Inject
import javax.inject.Singleton

interface LastFMProvider {
    fun saveToken(token: String)
}

@Singleton
class LastFMProviderImpl @Inject constructor(
    private val caller: Caller,
    private val securedPrefsRepository: SecuredPrefsRepository
): LastFMProvider {

    override fun saveToken(token: String) {
        TODO("Not yet implemented")
    }
}