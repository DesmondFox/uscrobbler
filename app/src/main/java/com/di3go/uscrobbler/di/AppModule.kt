package com.di3go.uscrobbler.di

import com.di3go.uscrobbler.data.providers.LastFMProvider
import com.di3go.uscrobbler.data.providers.LastFMProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.umass.lastfm.Caller
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideLastFMRepositoryImpl(): LastFMProvider {
        return LastFMProviderImpl(
            provideLastFMCaller()
        )
    }

    @Provides
    @Singleton
    fun provideLastFMCaller(): Caller {
        return Caller.getInstance()
    }
}