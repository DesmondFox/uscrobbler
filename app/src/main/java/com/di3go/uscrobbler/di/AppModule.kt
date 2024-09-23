package com.di3go.uscrobbler.di

import com.di3go.uscrobbler.LastFMRepository
import com.di3go.uscrobbler.LastFMRepositoryImpl
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
    fun provideLastFMRepositoryImpl(): LastFMRepository {
        return LastFMRepositoryImpl(
            provideLastFMCaller()
        )
    }

    @Provides
    @Singleton
    fun provideLastFMCaller(): Caller {
        return Caller.getInstance()
    }
}