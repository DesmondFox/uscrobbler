package com.di3go.uscrobbler.data.repositories

import android.content.SharedPreferences
import android.util.Log
import com.di3go.uscrobbler.utils.SecuredPrefsManager
import javax.inject.Inject
import javax.inject.Singleton

interface SecuredPrefsRepository {
    fun saveToken(token: String)

    fun getToken(): String?
}

@Singleton
class SecuredPrefsRepositoryImpl @Inject constructor(
    private val securedPrefs: SecuredPrefsManager
) : SecuredPrefsRepository {
    override fun saveToken(token: String) {
        securedPrefs.instance.edit().putString(TOKEN, token).apply()
        Log.d(TAG, "Token saved")
    }

    override fun getToken(): String? {
        return securedPrefs.instance.getString(TOKEN, null)
    }

    companion object {
        const val TAG = "SecuredPrefsRepository"
        const val TOKEN = "token"
    }
}