package com.di3go.uscrobbler.data.repositories

import android.content.SharedPreferences
import com.di3go.uscrobbler.utils.SecuredPrefsManager
import javax.inject.Inject
import javax.inject.Singleton

interface SecuredPrefsRepository {
}

@Singleton
class SecuredPrefsRepositoryImpl @Inject constructor(
    private val securedPrefs: SecuredPrefsManager
) : SecuredPrefsRepository {
}