package com.di3go.uscrobbler.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.di3go.uscrobbler.Contract.SECURED_PREFS_FILENAME
import com.di3go.uscrobbler.UApp
import com.di3go.uscrobbler.utils.SecuredPrefsManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PreferencesModule {

}