package com.di3go.uscrobbler.utils

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.di3go.uscrobbler.Contract.SECURED_PREFS_FILENAME
import dagger.hilt.android.qualifiers.ApplicationContext

class SecuredPrefsManager(@ApplicationContext context: Context) {
    private val masterKey by lazy {
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
    }

    val instance by lazy {
        EncryptedSharedPreferences.create(
            context,
            SECURED_PREFS_FILENAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}