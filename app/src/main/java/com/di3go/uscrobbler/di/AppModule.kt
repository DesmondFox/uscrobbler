package com.di3go.uscrobbler.di

import android.content.Context
import com.di3go.uscrobbler.data.providers.LastFMProvider
import com.di3go.uscrobbler.data.providers.LastFMProviderImpl
import com.di3go.uscrobbler.data.repositories.SecuredPrefsRepository
import com.di3go.uscrobbler.data.repositories.SecuredPrefsRepositoryImpl
import com.di3go.uscrobbler.utils.SecuredPrefsManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import de.umass.lastfm.Caller
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideLastFMProviderImpl(
        @ApplicationContext context: Context
    ): LastFMProvider {
        return LastFMProviderImpl(
            provideLastFMCaller(),
            provideSecuredPrefsRepository(context)
        )
    }

    @Provides
    @Singleton
    fun provideLastFMCaller(): Caller {
        return Caller.getInstance()
    }

    @Provides
    fun provideSecuredPrefsRepository(
        @ApplicationContext context: Context
    ): SecuredPrefsRepository {
        return SecuredPrefsRepositoryImpl(provideSecuredPreferences(context))
    }

    @Singleton
    @Provides
    fun provideSecuredPreferences(
        @ApplicationContext appContext: Context,
    ): SecuredPrefsManager {
        return SecuredPrefsManager(appContext)
    }
}